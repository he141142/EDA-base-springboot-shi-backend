package com.example.demo.core.ports.repo;

import com.example.demo.domain.Sport;
import com.example.demo.domain.Team;
import com.example.demo.dto.Paginate;

import java.util.List;

public interface ISportPort {
    List<Team> GetAllTeamsByCountryCode(String iso);
    Paginate<Sport, List<Sport>> GetAllSports(int page, int limit);
}
