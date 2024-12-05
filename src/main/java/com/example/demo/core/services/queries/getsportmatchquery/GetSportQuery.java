package com.example.demo.core.services.queries.getsportmatchquery;

import com.example.demo.domain.SportMatch;
import lombok.Getter;
import sykros.cloud.edacore.internal.ddd.Query;

@Getter
public class GetSportQuery implements Query<SportMatch> {
   private String id;


}
