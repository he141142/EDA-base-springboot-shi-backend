package com.example.demo.domain.events;

import com.example.demo.domain.Country;
import com.example.demo.domain.Team;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamCreated {
    public static final String NAME = "TeamCreated";
    @JsonProperty("team_type")
    Team.TeamType teamType;
    @JsonProperty("team_name")
    String teamName;
    @JsonProperty("country")
    Country country;
}
