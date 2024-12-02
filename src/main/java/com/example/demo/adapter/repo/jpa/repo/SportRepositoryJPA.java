package com.example.demo.adapter.repo.jpa.repo;

import com.example.demo.adapter.repo.jpa.models.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepositoryJPA extends JpaRepository<Sport, Long> {
}
