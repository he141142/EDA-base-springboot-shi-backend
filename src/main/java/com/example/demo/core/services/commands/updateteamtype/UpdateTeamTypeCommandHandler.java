package com.example.demo.core.services.commands.updateteamtype;

import com.example.demo.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sykros.cloud.edacore.internal.cqs.CommandHandler;
import sykros.cloud.edacore.internal.es.EsStore;

@Service
public class UpdateTeamTypeCommandHandler implements CommandHandler<Team, UpdateTeamTypeCommand> {
    EsStore<Team> teamEsStore;

    @Autowired
    public void setTeamEsStore(EsStore<Team> teamEsStore) {
        this.teamEsStore = teamEsStore;
    }

    @Override
    public Team HandleCommand(UpdateTeamTypeCommand cmd) throws Exception {
        Team team = new Team(cmd.teamId);
        team = teamEsStore.Load(team);
        team.setTeamType(cmd.getTeamType());
        teamEsStore.Save(team);
        return team;
    }
}
