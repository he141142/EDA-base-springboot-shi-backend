package com.example.demo.core.services.commands.createteam;

import com.example.demo.core.cqs.Command;
import com.example.demo.core.cqs.CommandBase;
import com.example.demo.domain.Team;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTeamCommand extends CommandBase<Team> {
    public static final String COMMAND = "com.example.demo.cmd.CreateTeamCommand";
//    public CreateTeamCommand() {
//        super();
//    }

    @JsonProperty("team_name")
    String teamName;

    @JsonProperty("team_type")
    Team.TeamType teamType;

    @JsonProperty("country_id")
    Long countryID;

    @Override
    public String GetName() {
        return COMMAND;
    }
}
