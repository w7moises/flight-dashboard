package com.app.backend.service;

import com.app.backend.dto.ReservaDto;
import com.app.backend.dto.create.CreateReservaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReservaService {

    Page<ReservaDto> getAllReservas(Pageable pageable);

    List<ReservaDto> getAllReservasByEmail(String email_address);

    ReservaDto getReservaById(Long reservaId);

    ReservaDto createReserva(CreateReservaDto reservaDto);

    ReservaDto updateReserva(Long reservaId, CreateReservaDto reservaDto);

    ReservaDto deleteReserva(Long reservaId);
}
