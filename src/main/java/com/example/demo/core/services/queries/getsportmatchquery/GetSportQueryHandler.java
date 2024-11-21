package com.example.demo.core.services.queries.getsportmatchquery;

import com.example.demo.core.cqs.QueryHandler;
import com.example.demo.core.es.AggregateStore;
import com.example.demo.domain.SportMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetSportQueryHandler implements QueryHandler<SportMatch, GetSportQuery> {

    AggregateStore<SportMatch> store;

    @Autowired
    public void setStore(AggregateStore<SportMatch> store) {
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
