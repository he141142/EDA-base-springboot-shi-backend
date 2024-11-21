package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;


@Getter
public class Paginate<T, Q extends List<T>> {

    @JsonProperty("total_page")
    private int totalPages;

    @JsonProperty("total_items")
    private int totalItems;

    @JsonProperty
    private Q data;

    public Paginate(int totalPages, int totalItems, Q data) {
        this.totalPages = totalPages;
        this.totalItems = totalItems;
        this.data = data;
    }
}
