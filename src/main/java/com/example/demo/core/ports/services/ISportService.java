package com.example.demo.core.ports.services;

import com.example.demo.domain.Sport;
import com.example.demo.domain.Team;
import com.example.demo.dto.Paginate;

import java.util.List;

public interface ISportService {
    List<Team> GetAllTeamsByCountryCode(String iso) throws Exception;
    Paginate<Sport, List<Sport>> GetAllSports(int page, int limit);
}
