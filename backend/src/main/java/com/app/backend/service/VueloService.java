package com.app.backend.service;

import com.app.backend.dto.VueloDto;
import com.app.backend.dto.create.CreateVueloDto;
import com.app.backend.model.Aereolinea;
import com.app.backend.model.Avion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VueloService {

    Page<VueloDto> getVuelos(Pageable pageable);

    VueloDto getVueloById(Long vueloId);

    List<Aereolinea> getAereolineas();

    List<Avion> getAviones();

    VueloDto createVuelo(CreateVueloDto createVueloDto);

    VueloDto updateVuelo(Long vueloId, CreateVueloDto createVueloDto);

    VueloDto deleteVuelo(Long vueloId);
}
