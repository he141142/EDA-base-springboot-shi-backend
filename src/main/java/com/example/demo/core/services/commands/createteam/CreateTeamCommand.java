package com.example.demo.core.services.commands.createteam;

import com.example.demo.domain.Team;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sykros.cloud.edacore.internal.ddd.Command;
import sykros.cloud.edacore.internal.ddd.CommandBase;


@Getter
@Setter
public class CreateTeamCommand extends CommandBase implements Command {
    public static final String COMMAND = "com.example.demo.cmd.CreateTeamCommand";
    @JsonProperty("team_name")
    String teamName;

    @JsonProperty("team_type")
    Team.TeamType teamType;

    @JsonProperty("country_id")
    Long countryID;

    public CreateTeamCommand(String teamName, Team.TeamType teamType, Long countryID) {
        this(COMMAND);
        this.teamName = teamName;
        this.teamType = teamType;
        this.countryID = countryID;
        this.setPayload(this);
    }

    private CreateTeamCommand(String name) {
        super(name);
    }

}
