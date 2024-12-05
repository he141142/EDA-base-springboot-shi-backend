package com.example.demo.adapter.repo.jpa.repo;

import com.example.demo.domain.SportMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sykros.cloud.edacore.internal.es.EsStore;

import javax.sql.DataSource;

@Repository
public class EsSportMatchRepoImpl implements EsStore<SportMatch> {
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
    public void Save(SportMatch sportMatch) throws Exception {
        var aggId = sportMatch.ID();
        var aggName = sportMatch.Name();

        var events = eventStoreJPA.findAllByStreamIdAndStreamNameAndStreamVersionGreaterThan(
                aggId,
                aggName,
                sportMatch.CurrentVersion()
        );

        return;
    }

    @Override
    public SportMatch Load(SportMatch sportMatch) {
        var aggId = sportMatch.ID();
        var aggName = sportMatch.Name();
        var events = eventStoreJPA.findAllByStreamIdAndStreamNameAndStreamVersionGreaterThan(
                aggId,
                aggName,
                sportMatch.CurrentVersion()
        );
        return null;
    }
}
