package com.example.test.repo;

import com.example.test.model.Nation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INationRepo extends JpaRepository<Nation,Long> {
}
