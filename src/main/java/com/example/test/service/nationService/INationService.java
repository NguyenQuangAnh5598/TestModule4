package com.example.test.service.nationService;


import com.example.test.model.Nation;

import java.util.Optional;

public interface INationService {
    Iterable<Nation> findAll();

    Optional<Nation> findByID(Long id);

    Nation save(Nation nation);

    void remove(Long id);

}
