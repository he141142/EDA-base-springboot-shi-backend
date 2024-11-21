package com.example.demo.core.services.commands.createsportmatch;

import com.example.demo.core.cqs.Command;
import com.example.demo.domain.Sport;
import com.example.demo.domain.SportMatch;

public class CreateSportMatchCommand implements Command<SportMatch> {
    private int team1;
    private int team2;
    private int sportId;
}
