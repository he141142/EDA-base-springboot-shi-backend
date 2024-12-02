package com.example.demo.domain.events;

import com.example.demo.domain.Country;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class TeamReAllocate {
    public static final String NAME = "TeamReAllocate";
    @JsonProperty("country")
    Country country;
}
