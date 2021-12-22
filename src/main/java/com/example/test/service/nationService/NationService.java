package com.example.test.service.nationService;

import com.example.test.model.Nation;
import com.example.test.repo.INationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NationService implements INationService {
    @Autowired
    INationRepo nationRepo;

    @Override
    public Iterable<Nation> findAll() {
        return nationRepo.findAll();
    }

    @Override
    public Optional<Nation> findByID(Long id) {
        return nationRepo.findById(id);
    }

    @Override
    public Nation save(Nation nation) {
        return nationRepo.save(nation);
    }

    @Override
    public void remove(Long id) {
        nationRepo.deleteById(id);
    }
}
