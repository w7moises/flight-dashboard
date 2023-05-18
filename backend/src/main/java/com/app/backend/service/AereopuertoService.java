package com.app.backend.service;

import com.app.backend.dto.AereopuertoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AereopuertoService {

    Page<AereopuertoDto> getAereopuertos(Pageable pageable);

    List<AereopuertoDto> getAereopuertos();

    AereopuertoDto getAereopuertoById(Long aereopuertoId);

    AereopuertoDto createAereopuerto(AereopuertoDto aereopuertoDto);

    AereopuertoDto updateAereopuerto(Long aereopuertoId, AereopuertoDto aereopuertoDto);

    AereopuertoDto deleteAereopuerto(Long aereopuertoId);
}
