package com.example.demo.adapter.repo;

import com.example.demo.adapter.repo.jpa.CountryRepositoryJPA;
import com.example.demo.core.ports.repo.ICountryRepo;
import com.example.demo.domain.Country;
import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CountryRepoImpl implements ICountryRepo {
    CountryRepositoryJPA countryRepositoryJPA;

    @Autowired
    public void setCountryRepositoryJPA(CountryRepositoryJPA countryRepositoryJPA) {
        this.countryRepositoryJPA = countryRepositoryJPA;
    }

    @Override
    public boolean CheckCountryExist(@Nonnull Long id) {
        return this.countryRepositoryJPA.existsById(id);
    }

    @Override
    public Country GetCountryById(@Nonnull Long id) {
        var country = this.countryRepositoryJPA.getCountryById(id);
        if (country.isEmpty()) {
            throw new IllegalArgumentException(Country.ERR_COUNTRY_NOT_FOUND);
        }

        var countryEntity = country.get();
        return Country
                .builder()
                .countryName(countryEntity.getName())
                .id(countryEntity.getId())
                .iso(countryEntity.getIso())
                .teams(countryEntity.getTeams().stream().map(team -> com.example.demo.domain.Team.builder()
                        .teamName(team.getTeamName())
                        .teamType(com.example.demo.domain.Team.ToTeamType(team.getTeamType()))
                        .build()).toList())
                .build();
    }
}
