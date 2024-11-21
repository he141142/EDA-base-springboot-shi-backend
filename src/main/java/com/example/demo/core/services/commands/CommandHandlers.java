package com.example.demo.core.services.commands;

import com.example.demo.core.am.AmReplyMessage;
import com.example.demo.core.cqs.Command;
import com.example.demo.core.ddd.DDDCommandHandler;

public class CommandHandlers implements DDDCommandHandler<Command<?>> {
    @Override
    public AmReplyMessage Handle(Command<?> command) {
        return switch (command.getClass().getName()) {
            case "CreateSportMatchCommand" -> doCreateMatch();
            case "UpdateSportMatchScoreCommand" -> doUpdateSportMatchScore();
            case "CreateTeamCommand" -> doCreateTeam();
            case "ChangeTeam1Command" -> doChangeTeam1();
            default -> throw new UnsupportedOperationException();
        };
    }

    private AmReplyMessage doCreateTeam() {
        throw new UnsupportedOperationException();
    }

    private AmReplyMessage doChangeTeam1() {
        throw new UnsupportedOperationException();
    }

    private AmReplyMessage doCreateMatch() {
        throw new UnsupportedOperationException();
    }

    private AmReplyMessage doUpdateSportMatchScore() {
        throw new UnsupportedOperationException();
    }

}
