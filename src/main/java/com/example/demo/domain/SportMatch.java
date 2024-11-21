package com.example.demo.domain;

import com.example.demo.core.ddd.Event;
import com.example.demo.core.es.BaseESAggregate;
import com.example.demo.core.es.EsAggregate;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SportMatch extends BaseESAggregate implements EsAggregate {
    public enum MatchLevel {
        CLUB, COUNTRY, REGION
    }

    public static final String AGGREGATE_NAME = "SportMatch";

    Long id;

    Sport sport;

    Team team1;

    Team team2;

    MatchLevel matchLevel;

    String header;

    String[] sponsor;

    String score;

    String matchDate;

    private EsAggregate agg;

    public SportMatch(String id) {
        super(id, AGGREGATE_NAME);
    }

    public SportMatch(String id, String name) {
        super(id, name);
    }


    @Override
    public void ApplyEvent(Event event) {

    }

}
