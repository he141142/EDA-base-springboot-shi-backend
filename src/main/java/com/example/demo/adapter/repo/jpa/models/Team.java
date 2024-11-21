package com.example.demo.adapter.repo.jpa.models;


import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "team",schema = "shi_dev")
@Getter
public class Team {

    @Id
    Long id;

    @Column(name = "team_name")
    String teamName;

    @Column(name = "team_type")
    String teamType;

    @Column(name = "country_code")
    String countryCode;

    @ManyToOne
    @JoinColumn(name = "country_code", referencedColumnName = "iso", insertable = false, updatable = false)
    Country country;
}
