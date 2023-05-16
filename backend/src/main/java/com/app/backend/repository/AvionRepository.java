package com.app.backend.repository;

import com.app.backend.model.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Long> {
}
