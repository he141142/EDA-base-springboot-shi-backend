package com.example.demo.core.ports.repo;

import com.example.demo.domain.Country;
import jakarta.annotation.Nonnull;

public interface ICountryRepo {
    boolean CheckCountryExist(@Nonnull Long id);
    Country GetCountryById(@Nonnull Long id);
}
