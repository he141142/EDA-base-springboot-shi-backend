package com.example.demo.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sport {
    Long id;
    private String name;
    private String description;
}
