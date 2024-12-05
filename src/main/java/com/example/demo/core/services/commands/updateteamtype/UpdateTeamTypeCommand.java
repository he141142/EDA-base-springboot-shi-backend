package com.example.demo.core.services.commands.updateteamtype;

import com.example.demo.domain.Team;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import sykros.cloud.edacore.internal.ddd.CommandBase;

@Setter
@Getter
public class UpdateTeamTypeCommand extends CommandBase {
    public static final String COMMAND = "com.example.demo.cmd.UpdateTeamTypeCommand";
    @JsonProperty("team_type")
    Team.TeamType teamType;

    String teamId;

    public UpdateTeamTypeCommand(Team.TeamType teamType) {
        super(COMMAND);
        this.teamType = teamType;
        this.setPayload(this);
    }

    private UpdateTeamTypeCommand(String name) {
        super(name);
    }
}
