package com.app.backend.service;

import com.app.backend.dto.CostoDto;
import com.app.backend.dto.create.CreateCostoDto;

import java.util.List;

public interface CostoService {

    List<CostoDto> getAllCostos();

    List<CostoDto> getAllCostosByVueloId(Long vueloId);

    CostoDto getCostoById(Long costoId);

    CostoDto createCosto(CreateCostoDto createCostoDto);

    CostoDto updateCosto(Long costoId, CreateCostoDto createCostoDto);

    CostoDto deleteCosto(Long costoId);
}
