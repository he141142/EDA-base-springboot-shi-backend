package com.example.demo.adapter.repo.jpa.repo;

import com.example.demo.adapter.repo.jpa.models.Country;
import com.example.demo.adapter.repo.jpa.models.Team;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CountryRepositoryJPA extends JpaRepository<Country, Long> {
    @Query("SELECT c.teams FROM Country c WHERE c.iso = :iso")
    List<Team> listAllTeamsByCountryCode(@Param("iso") String iso);

    Optional<Country> getCountryByIso(@Nonnull String iso);

    List<Country> findAllByIsoOrName(@Nonnull String iso,@Nonnull String name);

    Optional<Country> getCountryById(@Nonnull Long id);

    boolean existsById(@Nonnull Long id);
}
