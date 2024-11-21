package com.example.demo.core.services.commands.createteam;

import com.example.demo.core.cqs.CommandHandler;
import com.example.demo.domain.Team;

public class CreateTeamCommandHandler implements CommandHandler<Team,CreateTeamCommand> {
    @Override
    public Team HandleCommand(CreateTeamCommand cmd) {
        return null;
    }
}
