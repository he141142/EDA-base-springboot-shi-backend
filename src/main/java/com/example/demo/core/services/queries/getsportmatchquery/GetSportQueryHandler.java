package com.example.demo.core.services.queries.getsportmatchquery;

import com.example.demo.domain.SportMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sykros.cloud.edacore.internal.cqs.QueryHandler;
import sykros.cloud.edacore.internal.es.EsStore;

@Service
public class GetSportQueryHandler implements QueryHandler<SportMatch, GetSportQuery> {

    EsStore<SportMatch> store;


    @Autowired
    public void setStore(EsStore<SportMatch> store) {
        this.store = store;
    }

    @Override
    public SportMatch HandleQuery(GetSportQuery query) {
        try {
            return store.Load(new SportMatch(query.getId()));
        } catch (Exception e) {
            return null;
        }
    }
}
