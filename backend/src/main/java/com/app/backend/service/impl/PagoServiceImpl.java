package com.app.backend.service.impl;

import com.app.backend.dto.PagoDto;
import com.app.backend.dto.create.CreatePagoDto;
import com.app.backend.exception.ResourceNotFoundException;
import com.app.backend.model.Pago;
import com.app.backend.model.Reserva;
import com.app.backend.model.Status;
import com.app.backend.repository.PagoRepository;
import com.app.backend.repository.ReservaRepository;
import com.app.backend.service.PagoService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoServiceImpl implements PagoService {

    private final PagoRepository pagoRepository;

    private final ReservaRepository reservaRepository;

    private final ModelMapper modelMapper;

    public PagoServiceImpl(PagoRepository pagoRepository, ReservaRepository reservaRepository, ModelMapper modelMapper) {
        this.pagoRepository = pagoRepository;
        this.reservaRepository = reservaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PagoDto> getAllPagos() {
        return pagoRepository.findAll().stream().map(data -> modelMapper.map(data, PagoDto.class)).toList();
    }

    @Override
    public PagoDto createPago(CreatePagoDto createPagoDto) {
        Reserva reserva = reservaRepository.findById(createPagoDto.getReservation_id()).orElseThrow(
                () -> new ResourceNotFoundException("Reserva", "id", createPagoDto.getReservation_id())
        );
        reserva.setReservation_status_code(Status.TERMINADO);
        Pago pago = new Pago();
        pago.setReservation(reserva);
        pago.setStatus(Status.TERMINADO);
        pago.setPayment_amount(createPagoDto.getPayment_amount());
        reservaRepository.save(reserva);
        return modelMapper.map(pagoRepository.save(pago), PagoDto.class);
    }
}
