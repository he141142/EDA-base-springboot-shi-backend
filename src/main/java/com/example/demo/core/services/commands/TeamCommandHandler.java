package com.example.demo.core.services.commands;

import com.example.demo.core.services.commands.createteam.CreateTeamCommand;
import com.example.demo.core.services.commands.updateteamtype.UpdateTeamTypeCommand;

import com.example.demo.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sykros.cloud.edacore.internal.am.reply.ReplyPublisherBase;
import sykros.cloud.edacore.internal.cqs.CommandHandler;
import sykros.cloud.edacore.internal.ddd.Command;
import sykros.cloud.edacore.internal.ddd.DDDCommandHandler;
import sykros.cloud.edacore.internal.ddd.Reply;
import sykros.cloud.edacore.internal.ddd.ReplyBase;

import java.util.Map;

@Service
public class TeamCommandHandler<T extends Command> implements DDDCommandHandler<T> {
    CommandHandler<Team, CreateTeamCommand> createTeamCommandHandler;
    CommandHandler<Team, UpdateTeamTypeCommand> updateTeamTypeCommandCommandHandler;

    @Autowired
    public void setCreateTeamCommandHandler(CommandHandler<Team, CreateTeamCommand> createTeamCommandHandler) {
        this.createTeamCommandHandler = createTeamCommandHandler;
    }

    @Autowired
    public void setUpdateTeamTypeCommandCommandHandler(CommandHandler<Team, UpdateTeamTypeCommand> updateTeamTypeCommandCommandHandler) {
        this.updateTeamTypeCommandCommandHandler = updateTeamTypeCommandCommandHandler;
    }


    @Override
    public Reply HandleCommand(T cmd) throws Exception {
        return switch (cmd.CommandName()) {
            case CreateTeamCommand.COMMAND -> HandleCreateTeamCommand((CreateTeamCommand) cmd);
            case UpdateTeamTypeCommand.COMMAND -> HandleUpdateTeamTypeCommand((UpdateTeamTypeCommand) cmd);
            default -> null;
        };
    }


    private Reply HandleCreateTeamCommand(CreateTeamCommand cmd) throws Exception {
        ReplyBase reply = new ReplyBase(Team.CREATE_TEAM_REPLY);
        try {
            createTeamCommandHandler.HandleCommand(cmd);
        } catch (Exception e) {
            reply.Failure();
            return reply;
        }
        reply.setMetadata(Map.of(
                ReplyPublisherBase.REPLY_PUBLISH_CHANNEL, Team.CREATE_TEAM_REPLY
        ));
        reply.setPayload(cmd);
        reply.Success();
        return reply;
    }

    private Reply HandleUpdateTeamTypeCommand(UpdateTeamTypeCommand cmd) throws Exception {
        ReplyBase reply = new ReplyBase(Team.UPDATE_TEAM_TYPE_REPLY);
        try {
            updateTeamTypeCommandCommandHandler.HandleCommand(cmd);
        } catch (Exception e) {
            reply.Failure();
            return reply;
        }
        reply.setMetadata(Map.of(
                ReplyPublisherBase.REPLY_PUBLISH_CHANNEL, Team.UPDATE_TEAM_TYPE_REPLY
        ));
        reply.setPayload(cmd);
        reply.Success();
        return reply;
    }

}
