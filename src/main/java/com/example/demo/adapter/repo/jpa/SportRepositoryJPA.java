package com.example.demo.adapter.repo.jpa;

import com.example.demo.adapter.repo.jpa.models.Sport;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface SportRepositoryJPA extends JpaRepository<Sport, Long> {
}
