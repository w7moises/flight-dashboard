package com.app.backend.repository;

import com.app.backend.model.Costo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostoRepository extends JpaRepository<Costo, Long> {
    List<Costo> findAllByFlight_FlightId(Long vueloId);
}
