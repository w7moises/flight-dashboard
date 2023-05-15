package com.app.backend.service;

import com.app.backend.dto.AereopuertoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AereopuertoService {

    Page<AereopuertoDto> getAereopuertos(Pageable pageable);

    AereopuertoDto getAereopuertoById(Long aereopuertoId);

    AereopuertoDto createAereopuerto(AereopuertoDto aereopuertoDto);

    AereopuertoDto updateAereopuerto(Long aereopuertoId, AereopuertoDto aereopuertoDto);

    AereopuertoDto deleteAereopuerto(Long aereopuertoId);
}
