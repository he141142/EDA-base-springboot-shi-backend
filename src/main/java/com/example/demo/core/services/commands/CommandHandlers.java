package com.example.demo.core.services.commands;

import com.example.demo.core.am.AmReplyMessage;
import com.example.demo.core.cqs.Command;
import com.example.demo.core.cqs.CommandHandler;
import com.example.demo.core.ddd.DDDCommandHandler;
import com.example.demo.core.services.commands.createteam.CreateTeamCommand;
import com.example.demo.domain.Team;
import lombok.Setter;

@Setter
public class CommandHandlers implements DDDCommandHandler<Command<?>> {

    CommandHandler<Team, CreateTeamCommand> createTeamCommandHandler;

    @Override
    public AmReplyMessage Handle(Command<?> command) throws Exception {
        return switch (command.GetName()) {
            case "CreateSportMatchCommand" -> doCreateMatch();
            case "UpdateSportMatchScoreCommand" -> doUpdateSportMatchScore();
            case CreateTeamCommand.COMMAND -> doCreateTeam(command);
            case "ChangeTeam1Command" -> doChangeTeam1();
            default -> throw new UnsupportedOperationException();
        };
    }

    private AmReplyMessage doCreateTeam(Command<?> cmd) throws Exception {
       try{
           Team t = this.createTeamCommandHandler.HandleCommand((CreateTeamCommand)cmd);
           return null;
       }catch (Exception e){
           System.out.println(e);
           throw e;
       }
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
