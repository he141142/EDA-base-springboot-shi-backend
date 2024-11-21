package com.example.demo.adapter.repo.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
@Table(name = "sport",schema = "shi_dev")
public class Sport {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "sport_name")
    private String name;

    @Column(name = "created_at")
    Date created_at;

    @Column(name = "updated_at")
    Date updated_at;
}
