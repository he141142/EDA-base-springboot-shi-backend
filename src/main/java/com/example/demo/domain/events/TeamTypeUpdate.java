package com.example.demo.domain.events;

import com.example.demo.domain.Team;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TeamTypeUpdate
{
    public static final String NAME = "TeamTypeUpdate";
    @JsonProperty("team_type")
    Team.TeamType teamType;
}
