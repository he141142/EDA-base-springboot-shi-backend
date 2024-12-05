package com.example.demo.adapter.repo.jpa.repo;

import com.example.demo.adapter.repo.jpa.models.Event;
import com.example.demo.domain.Team;
import com.example.demo.infra.postgres.PgConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sykros.cloud.edacore.internal.ddd.event.EventBase;
import sykros.cloud.edacore.internal.ddd.event.IEvent;
import sykros.cloud.edacore.internal.es.EsStore;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;


@Repository
public class EsTeamRepoImpl implements EsStore<Team> {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(EsTeamRepoImpl.class);
    EventStoreJPA eventStoreJPA;
    DataSource dataSource;
    PgConfig pgConfig;

    @Autowired
    public void setPgConfig(PgConfig pgConfig) {
        this.pgConfig = pgConfig;
    }

    @Autowired
    public void setEventStoreJPA(EventStoreJPA eventStoreJPA) {
        this.eventStoreJPA = eventStoreJPA;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void Save(Team entity) throws Exception {
        for (IEvent event : entity.Events()) {
            entity.Apply(event);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        Object[][] values = entity.Events()
                .stream()
                .map(event -> transformEventToObject(event, objectMapper, entity))
                .filter(Objects::nonNull)
                .toArray(Object[][]::new);
        try (
                var conn = dataSource.getConnection();
                PreparedStatement stmt = generateInsertStmt(
                        new String[]{
                                "stream_id", "stream_name", "stream_version",
                                "event_id", "event_name", "event_data", "occurred_at"
                        }, Event.TABLE_NAME, values, conn
                )
        ) {
            conn.beginRequest();
            var result = stmt.executeQuery();
            if (result.rowInserted()) {
                logger.info("Event inserted");
            }
            conn.commit();
        } catch (Exception e) {
            logger.error("Error saving events", e);
            throw new Exception("Error saving events");
        }
        entity.CommitEvents();
    }

    @Override
    public Team Load(Team entity) throws Exception {
        Optional<List<Event>> eventsIfExist = this.eventStoreJPA.findAllByStreamIdAndStreamNameAndStreamVersionGreaterThan(
                entity.ID(),
                entity.Name(),
                entity.CurrentVersion()
        );
        if (eventsIfExist.isEmpty()) {
            throw new Exception("Events not found");
        }
        var events = eventsIfExist.get();

        List<? extends IEvent> eventLoad = events
                .stream().map(event -> {
                    EventBase eventBase = new EventBase(event.getEventId(), event.getEventName());
                    eventBase.setPayload(event.getEventData());
                    eventBase.setOccurredOn(event.getOccurredAt());
                    return eventBase;
                }).toList();

        for (IEvent event : eventLoad) {
            entity.Apply(event);
        }

        return entity;
    }


    private PreparedStatement generateInsertStmt(String[] columns, String table, Object[][] values, Connection conn) throws Exception {
        StringBuilder insertStmt = new StringBuilder();
        insertStmt.append(String.format("INSERT INTO %s.%s (%s) VALUES ",
                pgConfig.getSchema(),
                table,
                String.join(",", columns)
        ));
        List<String> valuePlaceHolder = new ArrayList<>();
        for (var o : values) {
            valuePlaceHolder.add("(" + String.join(",", Stream.of(o).map(v -> "?").toList()) + ")");
        }
        insertStmt.append(String.join(",", valuePlaceHolder));
        PreparedStatement stmt = conn.prepareStatement(insertStmt.toString());
        setStmtValue(stmt, values);
        return stmt;
    }

    private void setStmtValue(PreparedStatement stmt, Object[] values) throws Exception {
        for (int i = 0; i < values.length; i++) {
            stmt.setObject(i + 1, values[i]);
        }
    }

    private Object[] transformEventToObject(IEvent event, ObjectMapper objectMapper, Team entity) {
        if (event.Metadata().isEmpty() || !event.Metadata().containsKey("agg_id") || !event.Metadata().containsKey("agg_version")) {
            return null;
        }
        int version = (int) event.Metadata().get("agg_version");
        try {
            byte[] jsonBytes = objectMapper.writeValueAsBytes(event.Payload());
            return new Object[]{
                    entity.ID(),
                    entity.Name(),
                    version,
                    event.ID(),
                    event.Name(),
                    jsonBytes,
                    event.OccurredOn()
            };
        } catch (JsonProcessingException e) {
            logger.error("Error converting event payload to json bytes", e);
            throw new RuntimeException(e);
        }
    }

}
