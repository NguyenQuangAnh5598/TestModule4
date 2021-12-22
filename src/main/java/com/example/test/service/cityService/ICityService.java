package com.example.test.service.cityService;

import com.example.test.model.City;

import java.util.Optional;

public interface ICityService {
    Iterable<City> findAll();

    Optional<City> findByID(Long id);

    City save(City city);

    void remove(Long id);

}
