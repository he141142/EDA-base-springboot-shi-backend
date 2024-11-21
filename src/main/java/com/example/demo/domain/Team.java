package com.example.demo.domain;

//
//CREATE TABLE team (
//        id SERIAL PRIMARY KEY,
//        team_name VARCHAR NOT NULL UNIQUE,
//        team_type VARCHAR CHECK (team_type IN ('Club', 'Country', 'Region')) NOT NULL,
//country_code VARCHAR REFERENCES ml_country(iso) ON DELETE SET NULL,
//created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
//updated_at TIMESTAMP WITH TIME ZONE DEFAULT NOW()
//);

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Setter;

@Builder
@Setter
public class Team {
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
