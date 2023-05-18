package com.app.backend.service;

import com.app.backend.dto.EscalaDto;
import com.app.backend.dto.create.CreateEscalaDto;

import java.util.List;

public interface EscalaService {

    List<EscalaDto> getAllEscalas();

    List<EscalaDto> getEscalasByVueloId(Long vueloId);

    EscalaDto getEscalaById(Long escalaId);

    EscalaDto createEscala(CreateEscalaDto escalaDto);

    EscalaDto updateEscala(Long escalaId, CreateEscalaDto escalaDto);

    EscalaDto deleteEscala(Long escalaId);
}
