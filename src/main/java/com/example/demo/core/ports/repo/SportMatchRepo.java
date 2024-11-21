package com.example.demo.core.ports.repo;

import com.example.demo.domain.SportMatch;

public interface SportMatchRepo {
    SportMatch Load(String matchID) throws Exception;

    void Save(SportMatch match) throws Exception;
}
