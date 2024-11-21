package com.example.demo.adapter.repo;

import com.example.demo.adapter.repo.jpa.TeamRepositoryJPA;
import com.example.demo.core.ports.repo.ITeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeamRepoImpl implements ITeamRepo {

    TeamRepositoryJPA teamRepositoryJPA;

    @Autowired
    public void setTeamRepositoryJPA(TeamRepositoryJPA teamRepositoryJPA) {
        this.teamRepositoryJPA = teamRepositoryJPA;
    }

    @Override
    public boolean IsTeamExist(String teamName, String teamType) {
        return teamRepositoryJPA.existsByTeamNameAndTeamType(teamName, teamType);
    }
}
