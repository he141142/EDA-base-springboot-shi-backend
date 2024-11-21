package com.example.demo.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Builder
@Setter
public class Team {
    public static final String ERR_INVALID_TEAM_TYPE = "ERR Invalid team type";
    public static TeamType ToTeamType(String teamType) {
        return TeamType.valueOf(teamType.toUpperCase());
    }

    public static String ToValidTeamType(String teamType) {
        Map<String, Boolean> validTeamType = Map.of(
                "Club", true,
                "Country", true,
                "Region", true
        );
        teamType = teamType.toUpperCase();
        teamType = teamType.charAt(0)+teamType.substring(1, teamType.length() - 1);

        if (validTeamType.containsKey(teamType)) {
            return teamType;
        }

        throw new IllegalArgumentException(ERR_INVALID_TEAM_TYPE);
    }

    public static final String ERR_TEAM_EXIST = "Err Team already exist";

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
}
