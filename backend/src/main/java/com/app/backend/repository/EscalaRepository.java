package com.app.backend.repository;

import com.app.backend.dto.EscalaDto;
import com.app.backend.model.Escala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EscalaRepository extends JpaRepository<Escala, Long> {
    List<Escala> findAllByFlight_FlightId(Long flightId);
}
