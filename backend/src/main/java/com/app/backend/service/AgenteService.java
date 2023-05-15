package com.app.backend.service;

import com.app.backend.dto.AgenteDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AgenteService {

    Page<AgenteDto> getAllAgentes(Pageable pageable);

    AgenteDto getAgenteById(Long agenteId);

    AgenteDto createAgente(AgenteDto agenteDto);

    AgenteDto updateAgente(Long agenteId, AgenteDto agenteDto);

    AgenteDto deleteAgente(Long agenteId);
}
