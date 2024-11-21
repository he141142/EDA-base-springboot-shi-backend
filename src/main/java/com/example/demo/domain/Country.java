package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Country {
    public final static String ERR_COUNTRY_NOT_FOUND = "Country not found";

    @JsonProperty("id")
    Long id;

    @JsonProperty("iso")
    String iso;

    @JsonProperty("country_name")
    String countryName;

    @JsonProperty("timezone")
    String timezone;

    @JsonProperty("teams")
    List<Team> teams;
}
