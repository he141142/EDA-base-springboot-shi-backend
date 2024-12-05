package com.example.demo.core.services.commands.createsportmatch;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import sykros.cloud.edacore.internal.ddd.CommandBase;

@Getter
@Setter
public class CreateSportMatchCommand extends CommandBase {
    private static final String CREATE_SPORT_MATCH_COMMAND = "CreateSportMatchCommand";

    public CreateSportMatchCommand(int team1, int team2, int sportId) {
        super(CREATE_SPORT_MATCH_COMMAND);
        this.team1 = team1;
        this.team2 = team2;
        this.sportId = sportId;
        this.setPayload(this);
    }


    @JsonProperty("team1")
    private int team1;
    @JsonProperty("team2")
    private int team2;
    @JsonProperty("sport_id")
    private int sportId;
}
