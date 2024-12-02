package com.example.demo.domain;

import com.example.demo.domain.events.TeamCreated;
import com.example.demo.domain.events.TeamTypeUpdate;
import com.example.demo.domain.events.TeamReAllocate;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import sykros.cloud.edacore.internal.am.event.EventMessageBase;
import sykros.cloud.edacore.internal.ddd.event.IEvent;
import sykros.cloud.edacore.internal.es.EsAggregate;
import sykros.cloud.edacore.internal.es.EsAggregateBase;
import sykros.cloud.edacore.internal.es.EventApplier;

import java.util.Map;

@SuperBuilder
@Setter
public class Team extends EsAggregateBase implements EsAggregate, EventApplier {

    private static final String AGGREGATE_NAME = "Team.Aggregate";
    public static final String ERR_INVALID_TEAM_TYPE = "ERR Invalid team type";

    public static TeamType ToTeamType(String teamType) {
        return TeamType.valueOf(teamType.toUpperCase());
    }

    @Override
    public void Apply(IEvent event) throws Exception {
        switch (event.Name()) {
            case TeamCreated.NAME:
                consumeTeamCreatedEvent(event.Payload());
                break;
            case TeamTypeUpdate.NAME:
                consumeTeamTypeUpdate(event.Payload());
                break;
            case TeamReAllocate.NAME:
                consumeTeamReAllocate(event.Payload());
                break;
            default:
                throw new IllegalArgumentException("Invalid event name");
        }
    }

    public enum TeamType {
        CLUB, COUNTRY, REGION
    }

    public static TeamType toTeamType(String teamType) {
        return TeamType.valueOf(teamType.toUpperCase());
    }

    @JsonProperty("id")
    Long id;

    @JsonProperty("team_type")
    TeamType teamType;

    @JsonProperty("team_name")
    String teamName;

    @JsonProperty("country")
    Country country;

    public Team() {
        super(AGGREGATE_NAME);
    }

    public IEvent CreateTeamV2(Country country, String teamType, String teamName) {
        this.teamType = ToTeamType(teamType);
        this.teamName = teamName;
        this.country = country;
        if (country.id == null) {
            throw new IllegalArgumentException(Country.ERR_COUNTRY_NOT_FOUND);
        }
        EventMessageBase createTeamEvent = new EventMessageBase(TeamCreated.NAME, this);
        this.AddEvent(createTeamEvent);
        return createTeamEvent;
    }

    public IEvent UpdateTeamType(String teamType) {
        this.teamType = ToTeamType(teamType);
        EventMessageBase updateTeamTypeEvent = new EventMessageBase(
                TeamTypeUpdate.NAME,
                this);

        this.AddEvent(updateTeamTypeEvent);
        return updateTeamTypeEvent;
    }

    public IEvent ReAllocateTeam(Country country) {
        this.country = country;
        EventMessageBase updateTeamTypeEvent = new EventMessageBase(
                TeamReAllocate.NAME,
                this);
        this.AddEvent(updateTeamTypeEvent);
        return updateTeamTypeEvent;
    }

    public static String ToValidTeamType(String teamType) {
        Map<String, Boolean> validTeamType = Map.of(
                "Club", true,
                "Country", true,
                "Region", true
        );
        teamType = teamType.toUpperCase();
        teamType = teamType.charAt(0) + teamType.substring(1, teamType.length() - 1);

        if (validTeamType.containsKey(teamType)) {
            return teamType;
        }

        throw new IllegalArgumentException(ERR_INVALID_TEAM_TYPE);
    }

    public static final String ERR_TEAM_EXIST = "Err Team already exist";


    // section utilities
    private void consumeTeamCreatedEvent(Object payload) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(payload);
        JsonNode rootNode = mapper.readTree(json);
        String teamType = rootNode.get("team_type").asText();
        String teamName = rootNode.get("team_name").asText();
        this.country = getCountryFromJsonNode(rootNode);
        this.teamName = teamName;
        this.teamType = Team.ToTeamType(teamType);
    }


    private void consumeTeamTypeUpdate(Object payload) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(payload);
        JsonNode rootNode = mapper.readTree(json);
        String teamType = rootNode.get("team_type").asText();
        this.teamType = Team.ToTeamType(teamType);
    }

    private void consumeTeamReAllocate(Object payload) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(payload);
        JsonNode rootNode = mapper.readTree(json);
        this.country = getCountryFromJsonNode(rootNode);
    }

    private static Country getCountryFromJsonNode(JsonNode rootNode) {
        JsonNode countryNode = rootNode.get("country");
        Long countryID = countryNode.get("id").asLong();
        String countryISO = countryNode.get("iso").asText();
        String countryName = countryNode.get("country_name").asText();
        String timezone = countryNode.get("timezone").asText();
        return Country.builder()
                .id(countryID)
                .iso(countryISO)
                .countryName(countryName)
                .timezone(timezone)
                .build();
    }
}
