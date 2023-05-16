package com.app.backend.service.impl;

import com.app.backend.dto.VueloDto;
import com.app.backend.dto.create.CreateVueloDto;
import com.app.backend.exception.ResourceNotFoundException;
import com.app.backend.model.Aereolinea;
import com.app.backend.model.Aereopuerto;
import com.app.backend.model.Avion;
import com.app.backend.model.Vuelo;
import com.app.backend.repository.AereolineaRepository;
import com.app.backend.repository.AereopuertoRepository;
import com.app.backend.repository.AvionRepository;
import com.app.backend.repository.VueloRepository;
import com.app.backend.service.VueloService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloServiceImpl implements VueloService {

    private final VueloRepository vueloRepository;

    private final AvionRepository avionRepository;

    private final AereopuertoRepository aereopuertoRepository;

    private final AereolineaRepository aereolineaRepository;

    private final ModelMapper modelMapper;

    public VueloServiceImpl(VueloRepository vueloRepository, AvionRepository avionRepository, AereopuertoRepository aereopuertoRepository, AereolineaRepository aereolineaRepository, ModelMapper modelMapper) {
        this.vueloRepository = vueloRepository;
        this.avionRepository = avionRepository;
        this.aereopuertoRepository = aereopuertoRepository;
        this.aereolineaRepository = aereolineaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<VueloDto> getVuelos(Pageable pageable) {
        return vueloRepository.findAll(pageable).map(vuelo -> modelMapper.map(vuelo, VueloDto.class));
    }

    @Override
    public VueloDto getVueloById(Long vueloId) {
        Vuelo optionalVuelo = vueloRepository.findById(vueloId).orElseThrow(
                () -> new ResourceNotFoundException("Vuelo", "id", vueloId)
        );
        return modelMapper.map(optionalVuelo, VueloDto.class);
    }

    @Override
    public List<Aereolinea> getAereolineas() {
        return aereolineaRepository.findAll();
    }

    @Override
    public List<Avion> getAviones() {
        return avionRepository.findAll();
    }

    @Override
    public VueloDto createVuelo(CreateVueloDto createVueloDto) {
        Avion optionalAvion = avionRepository.findById(createVueloDto.getAirplane_id()).orElseThrow(
                () -> new ResourceNotFoundException("Avion", "id", createVueloDto.getAirplane_id())
        );
        Aereolinea optionalAereolinea = aereolineaRepository.findById(createVueloDto.getAirline_id()).orElseThrow(
                () -> new ResourceNotFoundException("Aereolinea", "id", createVueloDto.getAirline_id())
        );
        Aereopuerto optionalAereopuertoOrigen = aereopuertoRepository.findById(createVueloDto.getOrigin_airport_id()).orElseThrow(
                () -> new ResourceNotFoundException("Aereopuerto", "id", createVueloDto.getOrigin_airport_id())
        );
        Aereopuerto optionalDAereopuertoDestino = aereopuertoRepository.findById(createVueloDto.getDestination_airport_id()).orElseThrow(
                () -> new ResourceNotFoundException("Aereopuerto", "id", createVueloDto.getDestination_airport_id())
        );
        Vuelo optionalVuelo = new Vuelo();
        optionalVuelo.setAirline(optionalAereolinea);
        optionalVuelo.setAirplane(optionalAvion);
        optionalVuelo.setOrigin_airport(optionalAereopuertoOrigen);
        optionalVuelo.setDestination_airport(optionalDAereopuertoDestino);
        optionalVuelo.setArrival_date(createVueloDto.getArrival_date());
        optionalVuelo.setArrival_time(createVueloDto.getArrival_time());
        optionalVuelo.setDeparture_date(createVueloDto.getDeparture_date());
        optionalVuelo.setDeparture_time(createVueloDto.getDeparture_time());
        return modelMapper.map(vueloRepository.save(optionalVuelo), VueloDto.class);
    }

    @Override
    public VueloDto updateVuelo(Long vueloId, CreateVueloDto createVueloDto) {
        Vuelo optionalVuelo = vueloRepository.findById(vueloId).orElseThrow(
                () -> new ResourceNotFoundException("Vuelo", "id", vueloId)
        );
        Avion optionalAvion = avionRepository.findById(createVueloDto.getAirplane_id()).orElseThrow(
                () -> new ResourceNotFoundException("Avion", "id", createVueloDto.getAirplane_id())
        );
        Aereolinea optionalAereolinea = aereolineaRepository.findById(createVueloDto.getAirline_id()).orElseThrow(
                () -> new ResourceNotFoundException("Aereolinea", "id", createVueloDto.getAirline_id())
        );
        Aereopuerto optionalAereopuertoOrigen = aereopuertoRepository.findById(createVueloDto.getOrigin_airport_id()).orElseThrow(
                () -> new ResourceNotFoundException("Aereopuerto", "id", createVueloDto.getOrigin_airport_id())
        );
        Aereopuerto optionalDAereopuertoDestino = aereopuertoRepository.findById(createVueloDto.getDestination_airport_id()).orElseThrow(
                () -> new ResourceNotFoundException("Aereopuerto", "id", createVueloDto.getDestination_airport_id())
        );
        optionalVuelo.setAirline(optionalAereolinea);
        optionalVuelo.setAirplane(optionalAvion);
        optionalVuelo.setOrigin_airport(optionalAereopuertoOrigen);
        optionalVuelo.setDestination_airport(optionalDAereopuertoDestino);
        optionalVuelo.setArrival_date(createVueloDto.getArrival_date());
        optionalVuelo.setArrival_time(createVueloDto.getArrival_time());
        optionalVuelo.setDeparture_date(createVueloDto.getDeparture_date());
        optionalVuelo.setDeparture_time(createVueloDto.getDeparture_time());
        return modelMapper.map(vueloRepository.save(optionalVuelo), VueloDto.class);
    }

    @Override
    public VueloDto deleteVuelo(Long vueloId) {
        Vuelo optionalVuelo = vueloRepository.findById(vueloId).orElseThrow(
                () -> new ResourceNotFoundException("Vuelo", "id", vueloId)
        );
        vueloRepository.deleteById(vueloId);
        return modelMapper.map(optionalVuelo, VueloDto.class);
    }
}
