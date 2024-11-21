package com.example.demo.core.services.commands.createsportmatch;

import com.example.demo.core.cqs.CommandHandler;
import com.example.demo.core.es.AggregateStore;
import com.example.demo.domain.SportMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateSportMatchCommandHandler implements CommandHandler<SportMatch,CreateSportMatchCommand> {
    AggregateStore<SportMatch> store;

    @Autowired
    public void setStore(AggregateStore<SportMatch> store) {
        this.store = store;
    }

    @Override
    public SportMatch HandleCommand(CreateSportMatchCommand cmd) {
        return null;
    }
}
