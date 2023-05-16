package com.app.backend.service;

import com.app.backend.dto.PagoDto;
import com.app.backend.dto.create.CreatePagoDto;

import java.util.List;

public interface PagoService {

    List<PagoDto> getAllPagos();

    PagoDto createPago(CreatePagoDto createPagoDto);
}
