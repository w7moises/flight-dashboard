package com.app.backend.repository;

import com.app.backend.model.Aereolinea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AereolineaRepository extends JpaRepository<Aereolinea, Long> {
}
