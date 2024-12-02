package com.example.demo.core.services.commands.createteam;

import com.example.demo.core.cqs.CommandHandler;
import com.example.demo.core.ports.repo.ICountryRepo;
import com.example.demo.core.ports.repo.ITeamRepo;
import com.example.demo.domain.Country;
import com.example.demo.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("CreateTeamCommandHandler")
public class CreateTeamCommandHandler implements CommandHandler<Team, CreateTeamCommand> {
    ICountryRepo countryRepo;
    @Autowired
    public void setCountryRepo(ICountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    ITeamRepo teamRepo;
    @Autowired
    public void setTeamRepo(ITeamRepo teamRepo) {
        this.teamRepo = teamRepo;
    }

    @Override
    public Team HandleCommand(CreateTeamCommand cmd) {
        if (!countryRepo.CheckCountryExist(cmd.getCountryID())) {
            throw new IllegalArgumentException(Country.ERR_COUNTRY_NOT_FOUND);
        }
        Country country = countryRepo.GetCountryById(cmd.getCountryID());

        if (teamRepo.IsTeamExist(cmd.getTeamName(), cmd.getTeamType().toString())) {
            throw new IllegalArgumentException(Team.ERR_TEAM_EXIST);
        }
        String teamType = Team.ToValidTeamType(cmd.getTeamType().toString());
        return Team.builder()
                .teamName(cmd.getTeamName())
                .teamType(Team.ToTeamType(teamType))
                .country(country)
                .build();
    }
}
