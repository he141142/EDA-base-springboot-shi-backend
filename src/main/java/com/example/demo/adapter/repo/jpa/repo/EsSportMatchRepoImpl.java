package com.example.demo.adapter.repo.jpa.repo;

import com.example.demo.core.es.AggregateStore;
import com.example.demo.domain.SportMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class EsSportMatchRepoImpl implements AggregateStore<SportMatch> {

    DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    EventStoreJPA eventStoreJPA;

    @Autowired
    public void setEventStoreJPA(EventStoreJPA eventStoreJPA) {
        this.eventStoreJPA = eventStoreJPA;
    }

    @Override
    public SportMatch Load(SportMatch sportMatch) throws Exception {
        var aggId = sportMatch.GetID();
        var aggName = sportMatch.GetName();

        var events = eventStoreJPA.findAllByStreamIdAndStreamNameAndStreamVersionGreaterThan(
                aggId,
                aggName,
                sportMatch.Version()
        );

        return null;
    }

    @Override
    public void Save(SportMatch aggregate) throws Exception {

    }
}
