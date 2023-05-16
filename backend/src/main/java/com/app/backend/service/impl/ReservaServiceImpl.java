package com.app.backend.service.impl;

import com.app.backend.dto.ReservaDto;
import com.app.backend.dto.create.CreateReservaDto;
import com.app.backend.exception.ResourceNotFoundException;
import com.app.backend.model.*;
import com.app.backend.repository.AgenteRepository;
import com.app.backend.repository.EscalaRepository;
import com.app.backend.repository.PasajeroRepository;
import com.app.backend.repository.ReservaRepository;
import com.app.backend.service.ReservaService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    private final AgenteRepository agenteRepository;

    private final PasajeroRepository pasajeroRepository;

    private final EscalaRepository escalaRepository;

    private final ModelMapper modelMapper;

    public ReservaServiceImpl(ReservaRepository reservaRepository, AgenteRepository agenteRepository, PasajeroRepository pasajeroRepository, EscalaRepository escalaRepository, ModelMapper modelMapper) {
        this.reservaRepository = reservaRepository;
        this.agenteRepository = agenteRepository;
        this.pasajeroRepository = pasajeroRepository;
        this.escalaRepository = escalaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<ReservaDto> getAllReservas(Pageable pageable) {
        return reservaRepository.findAll(pageable).map(reserva -> modelMapper.map(reserva, ReservaDto.class));
    }

    @Override
    public ReservaDto getReservaById(Long reservaId) {
        Reserva reserva = reservaRepository.findById(reservaId).orElseThrow(
                () -> new ResourceNotFoundException("Reserva", "id", reservaId)
        );
        return modelMapper.map(reserva, ReservaDto.class);
    }

    @Override
    public ReservaDto createReserva(CreateReservaDto reservaDto) {
        Agente agente = agenteRepository.findById(reservaDto.getAgent_id()).orElseThrow(
                () -> new ResourceNotFoundException("Agente", "id", reservaDto.getAgent_id())
        );
        Pasajero pasajero = pasajeroRepository.findById(reservaDto.getPassenger_id()).orElseThrow(
                () -> new ResourceNotFoundException("Pasajero", "id", reservaDto.getPassenger_id())
        );
        Escala escala = escalaRepository.findById(reservaDto.getLeg_id()).orElseThrow(
                () -> new ResourceNotFoundException("Escala", "id", reservaDto.getLeg_id())
        );
        Reserva reserva = new Reserva();
        reserva.setAgent(agente);
        reserva.setPassenger(pasajero);
        reserva.setReservation_status_code(Status.EN_PROCESO);
        reserva.setTravel_type_class(reservaDto.getTravel_type_class());
        reserva.setNumber_in_party(reservaDto.getNumber_in_party());
        reserva.setLeg(escala);
        reserva.setTicket_code("RV00" + escala.getLeg_id().toString());
        return modelMapper.map(reservaRepository.save(reserva), ReservaDto.class);
    }

    @Override
    public ReservaDto updateReserva(Long reservaId, CreateReservaDto reservaDto) {
        Reserva reserva = reservaRepository.findById(reservaId).orElseThrow(
                () -> new ResourceNotFoundException("Reserva", "id", reservaId)
        );
        Agente agente = agenteRepository.findById(reservaDto.getAgent_id()).orElseThrow(
                () -> new ResourceNotFoundException("Agente", "id", reservaDto.getAgent_id())
        );
        Pasajero pasajero = pasajeroRepository.findById(reservaDto.getPassenger_id()).orElseThrow(
                () -> new ResourceNotFoundException("Pasajero", "id", reservaDto.getPassenger_id())
        );
        Escala escala = escalaRepository.findById(reservaDto.getLeg_id()).orElseThrow(
                () -> new ResourceNotFoundException("Escala", "id", reservaDto.getLeg_id())
        );
        reserva.setAgent(agente);
        reserva.setPassenger(pasajero);
        reserva.setReservation_status_code(Status.EN_PROCESO);
        reserva.setTravel_type_class(reservaDto.getTravel_type_class());
        reserva.setNumber_in_party(reservaDto.getNumber_in_party());
        reserva.setLeg(escala);
        reserva.setTicket_code("RV00" + escala.getLeg_id().toString());
        return modelMapper.map(reservaRepository.save(reserva), ReservaDto.class);
    }

    @Override
    public ReservaDto deleteReserva(Long reservaId) {
        Reserva reserva = reservaRepository.findById(reservaId).orElseThrow(
                () -> new ResourceNotFoundException("Reserva", "id", reservaId)
        );
        reserva.setReservation_status_code(Status.CANCELADO);
        return modelMapper.map(reservaRepository.save(reserva),ReservaDto.class);
    }
}
