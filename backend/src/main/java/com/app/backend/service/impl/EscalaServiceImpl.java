package com.app.backend.service.impl;

import com.app.backend.dto.EscalaDto;
import com.app.backend.dto.create.CreateEscalaDto;
import com.app.backend.exception.ResourceNotFoundException;
import com.app.backend.model.Aereopuerto;
import com.app.backend.model.Escala;
import com.app.backend.model.Vuelo;
import com.app.backend.repository.AereopuertoRepository;
import com.app.backend.repository.EscalaRepository;
import com.app.backend.repository.VueloRepository;
import com.app.backend.service.EscalaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscalaServiceImpl implements EscalaService {

    private final EscalaRepository escalaRepository;

    private final AereopuertoRepository aereopuertoRepository;

    private final VueloRepository vueloRepository;

    private final ModelMapper modelMapper;

    public EscalaServiceImpl(EscalaRepository escalaRepository, AereopuertoRepository aereopuertoRepository, VueloRepository vueloRepository, ModelMapper modelMapper) {
        this.escalaRepository = escalaRepository;
        this.aereopuertoRepository = aereopuertoRepository;
        this.vueloRepository = vueloRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EscalaDto> getAllEscalas() {
        return escalaRepository.findAll().stream().map(escala -> modelMapper.map(escala, EscalaDto.class)).toList();
    }

    @Override
    public List<EscalaDto> getEscalasByVueloId(Long vueloId) {
        return escalaRepository.findAllByFlight_FlightId(vueloId).stream().map(escala -> modelMapper.map(escala, EscalaDto.class)).toList();
    }

    @Override
    public EscalaDto getEscalaById(Long escalaId) {
        Escala escala = escalaRepository.findById(escalaId).orElseThrow(
                () -> new ResourceNotFoundException("Escala", "id", escalaId)
        );
        return modelMapper.map(escala, EscalaDto.class);
    }

    @Override
    public EscalaDto createEscala(CreateEscalaDto escalaDto) {
        Aereopuerto optionalAereopuertoOrigen = aereopuertoRepository.findById(escalaDto.getOriginAirportId()).orElseThrow(
                () -> new ResourceNotFoundException("Aereopuerto", "id", escalaDto.getOriginAirportId())
        );
        Aereopuerto optionalDAereopuertoDestino = aereopuertoRepository.findById(escalaDto.getDestinationAirportId()).orElseThrow(
                () -> new ResourceNotFoundException("Aereopuerto", "id", escalaDto.getDestinationAirportId())
        );
        Vuelo optionalVuelo = vueloRepository.findById(escalaDto.getFlightId()).orElseThrow(
                () -> new ResourceNotFoundException("Vuelo", "id", escalaDto.getFlightId())
        );
        Escala escala = new Escala();
        escala.setFlight(optionalVuelo);
        escala.setOrigin_airport(optionalAereopuertoOrigen);
        escala.setDestination_airport(optionalDAereopuertoDestino);
        escala.setActualArrivalDate(escalaDto.getActualArrivalDate());
        escala.setActualArrivalTime(escalaDto.getActualArrivalTime());
        escala.setActualDepartureDate(escalaDto.getActualDepartureDate());
        escala.setActualDepartureTime(escalaDto.getActualDepartureTime());
        return modelMapper.map(escalaRepository.save(escala), EscalaDto.class);
    }

    @Override
    public EscalaDto updateEscala(Long escalaId, CreateEscalaDto escalaDto) {
        Escala optionalEscala = escalaRepository.findById(escalaId).orElseThrow(
                () -> new ResourceNotFoundException("Escala", "id", escalaId)
        );
        Aereopuerto optionalAereopuertoOrigen = aereopuertoRepository.findById(escalaDto.getOriginAirportId()).orElseThrow(
                () -> new ResourceNotFoundException("Aereopuerto", "id", escalaDto.getOriginAirportId())
        );
        Aereopuerto optionalDAereopuertoDestino = aereopuertoRepository.findById(escalaDto.getDestinationAirportId()).orElseThrow(
                () -> new ResourceNotFoundException("Aereopuerto", "id", escalaDto.getDestinationAirportId())
        );
        Vuelo optionalVuelo = vueloRepository.findById(escalaDto.getFlightId()).orElseThrow(
                () -> new ResourceNotFoundException("Vuelo", "id", escalaDto.getFlightId())
        );
        optionalEscala.setFlight(optionalVuelo);
        optionalEscala.setOrigin_airport(optionalAereopuertoOrigen);
        optionalEscala.setDestination_airport(optionalDAereopuertoDestino);
        optionalEscala.setActualArrivalDate(escalaDto.getActualArrivalDate());
        optionalEscala.setActualArrivalTime(escalaDto.getActualArrivalTime());
        optionalEscala.setActualDepartureDate(escalaDto.getActualDepartureDate());
        optionalEscala.setActualDepartureTime(escalaDto.getActualDepartureTime());
        return modelMapper.map(escalaRepository.save(optionalEscala), EscalaDto.class);
    }

    @Override
    public EscalaDto deleteEscala(Long escalaId) {
        Escala optionalEscala = escalaRepository.findById(escalaId).orElseThrow(
                () -> new ResourceNotFoundException("Escala", "id", escalaId)
        );
        escalaRepository.deleteById(escalaId);
        return modelMapper.map(optionalEscala, EscalaDto.class);
    }
}
