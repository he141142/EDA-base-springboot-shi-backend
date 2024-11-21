package com.example.demo.adapter.repo.jpa;

import com.example.demo.adapter.repo.jpa.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepositoryJPA extends JpaRepository<Team,Long> {
    boolean existsByTeamNameAndTeamType(String teamName, String teamType);
}
