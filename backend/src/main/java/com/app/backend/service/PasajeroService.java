package com.app.backend.service;

import com.app.backend.dto.PasajeroDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PasajeroService {

    Page<PasajeroDto> getAllPasajeros(Pageable pageable);

    List<PasajeroDto> getAllPasajeros();

    PasajeroDto getPasajeroById(Long pasajeroId);

    PasajeroDto createPasajero(PasajeroDto pasajeroDto);

    PasajeroDto updatePasajero(Long pasajeroId, PasajeroDto pasajeroDto);

    PasajeroDto deletePasajero(Long pasajeroId);
}
