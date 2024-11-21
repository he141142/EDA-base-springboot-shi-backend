package com.example.demo.adapter.repo.jpa.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "ml_country",schema = "shi_dev")
@Getter
@Setter
public class Country {

    @Id
    private Long id;

    @Column(name = "country_name")
    private String name;

    @Column(name = "iso")
    private String iso;

    @OneToMany(mappedBy = "country")
    List<Team> teams;
}
