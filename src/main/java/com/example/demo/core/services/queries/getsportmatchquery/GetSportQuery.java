package com.example.demo.core.services.queries.getsportmatchquery;

import com.example.demo.core.cqs.Query;
import com.example.demo.domain.SportMatch;
import lombok.Getter;

@Getter
public class GetSportQuery implements Query<SportMatch> {
   private String id;
}
