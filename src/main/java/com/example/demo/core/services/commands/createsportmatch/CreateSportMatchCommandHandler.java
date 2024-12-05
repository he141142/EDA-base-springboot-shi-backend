package com.example.demo.core.services.commands.createsportmatch;

import com.example.demo.domain.SportMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sykros.cloud.edacore.internal.cqs.CommandHandler;
import sykros.cloud.edacore.internal.es.EsStore;

@Service
public class CreateSportMatchCommandHandler implements CommandHandler<SportMatch,CreateSportMatchCommand> {
    EsStore<SportMatch> store;

    @Autowired
    public void setStore(EsStore<SportMatch> store) {
        this.store = store;
    }

    @Override
    public SportMatch HandleCommand(CreateSportMatchCommand cmd) {
        return null;
    }
}
