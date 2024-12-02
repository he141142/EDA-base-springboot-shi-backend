package com.example.demo.adapter.repo.jpa.repo;

import com.example.demo.adapter.repo.jpa.models.Country;
import com.example.demo.domain.Sport;
import com.example.demo.domain.Team;
import com.example.demo.core.ports.repo.ISportPort;
import com.example.demo.dto.Paginate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class SportRepoImpl implements ISportPort {
    CountryRepositoryJPA countryRepositoryJPA;
    SportRepositoryJPA sportRepositoryJPA;
    TeamRepositoryJPA teamRepositoryJPA;

    @Autowired
    public void setSportRepositoryJPA(SportRepositoryJPA sportRepositoryJPA) {
        this.sportRepositoryJPA = sportRepositoryJPA;
    }

    @Autowired
    public void setCountryRepositoryJPA(CountryRepositoryJPA countryRepositoryJPA) {
        this.countryRepositoryJPA = countryRepositoryJPA;
    }

    @Autowired
    public void setTeamRepositoryJPA(TeamRepositoryJPA teamRepositoryJPA) {
        this.teamRepositoryJPA = teamRepositoryJPA;
    }

    @Override
    public List<Team> GetAllTeamsByCountryCode(String iso) {
        Optional<Country> country = countryRepositoryJPA.getCountryByIso(iso);

        if (country.isEmpty()) {
            return List.of();
        }

        var countryEntity = com.example.demo.domain.Country
                .builder()
                .countryName(country.get().getName())
                .id(country.get().getId())
                .iso(country.get().getIso())
                .build();

        List<Team> teams = country.get().getTeams().stream().map(team -> {
            Team t = new Team();
            t.setId(team.getId());
            t.setTeamName(team.getTeamName());
            t.setTeamType(Team.ToTeamType(team.getTeamType()));
            return t;
        }).toList();
        teams.forEach(team -> team.setCountry(countryEntity));
        return teams;
    }

    @Override
    public Paginate<Sport, List<Sport>> GetAllSports(int page, int limit) {
        Pageable paging = PageRequest.of(Math.max(page - 1, 0), limit);
        var sports = this.sportRepositoryJPA.findAll(paging);

        return new Paginate<>(
                sports.getTotalPages(),
                (int) sports.getTotalElements(),
                sports
                        .getContent().stream().map(
                                sport -> Sport.builder()
                                        .id(sport.getId())
                                        .name(sport.getName())
                                        .build()
                        ).toList()
        );
    }


}
