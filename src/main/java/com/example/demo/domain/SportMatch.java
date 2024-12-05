package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import sykros.cloud.edacore.internal.ddd.event.IEvent;
import sykros.cloud.edacore.internal.es.EsAggregate;
import sykros.cloud.edacore.internal.es.EsAggregateBase;
import sykros.cloud.edacore.internal.es.EsStoreEntity;
import sykros.cloud.edacore.internal.es.EventApplier;


@Getter
@Setter
public class SportMatch extends EsAggregateBase implements EsAggregate, EventApplier, EsStoreEntity {
    @Override
    public void Apply(IEvent event) throws Exception {
    }
    public enum MatchLevel {
        CLUB, COUNTRY, REGION
    }
    public static final String AGGREGATE_NAME = "SportMatch";

    Long id;

    Sport sport;

    Team team1;

    Team team2;

    MatchLevel matchLevel;

    String header;

    String[] sponsor;

    String score;

    String matchDate;

    public SportMatch() {
        super(AGGREGATE_NAME);
    }

    public SportMatch(String id) {
        super(id,AGGREGATE_NAME);
    }

}
