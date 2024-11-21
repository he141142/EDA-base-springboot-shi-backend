package com.example.demo.core.services;

import com.example.demo.domain.Sport;
import com.example.demo.domain.Team;
import com.example.demo.core.ports.repo.ISportPort;
import com.example.demo.core.ports.services.ISportService;
import com.example.demo.dto.Paginate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportService implements ISportService {
    ISportPort sportPort;

    @Autowired
    public void setSportPort(ISportPort sportPort) {
        this.sportPort = sportPort;
    }

    @Override
    public List<Team> GetAllTeamsByCountryCode(String iso) throws Exception {
        var teams = this.sportPort.GetAllTeamsByCountryCode(iso);
        if (teams.isEmpty()) {
            throw new Exception("No teams found for the given country code");
        }
        return teams;
    }

    @Override
    public Paginate<Sport, List<Sport>> GetAllSports(int page, int limit) {
        return this.sportPort.GetAllSports(page, limit);
    }
}
