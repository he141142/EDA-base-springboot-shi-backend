package com.example.demo.core.services.commands.createsportmatch;

import com.example.demo.core.cqs.Command;
import com.example.demo.core.cqs.CommandBase;
import com.example.demo.domain.Sport;
import com.example.demo.domain.SportMatch;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSportMatchCommand extends CommandBase<SportMatch> {
    public CreateSportMatchCommand() {
        super();
    }
    private int team1;
    private int team2;
    private int sportId;
}
