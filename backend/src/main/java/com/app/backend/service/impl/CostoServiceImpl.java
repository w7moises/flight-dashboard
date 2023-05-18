package com.app.backend.service.impl;

import com.app.backend.dto.CostoDto;
import com.app.backend.dto.create.CreateCostoDto;
import com.app.backend.exception.ResourceNotFoundException;
import com.app.backend.model.Aereolinea;
import com.app.backend.model.Costo;
import com.app.backend.model.Vuelo;
import com.app.backend.repository.AereolineaRepository;
import com.app.backend.repository.CostoRepository;
import com.app.backend.repository.VueloRepository;
import com.app.backend.service.CostoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostoServiceImpl implements CostoService {

    private final CostoRepository costoRepository;

    private final VueloRepository vueloRepository;

    private final AereolineaRepository aereolineaRepository;

    private final ModelMapper modelMapper;

    public CostoServiceImpl(CostoRepository costoRepository, VueloRepository vueloRepository, AereolineaRepository aereolineaRepository, ModelMapper modelMapper) {
        this.costoRepository = costoRepository;
        this.vueloRepository = vueloRepository;
        this.aereolineaRepository = aereolineaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CostoDto> getAllCostos() {
        return costoRepository.findAll().stream().map(costo -> modelMapper.map(costo, CostoDto.class)).toList();
    }

    @Override
    public List<CostoDto> getAllCostosByVueloId(Long vueloId) {
        return costoRepository.findAllByFlight_FlightId(vueloId).stream().map(costo -> modelMapper.map(costo, CostoDto.class)).toList();
    }

    @Override
    public CostoDto getCostoById(Long costoId) {
        Costo costo = costoRepository.findById(costoId).orElseThrow(
                () -> new ResourceNotFoundException("Costo", "id", costoId)
        );
        return modelMapper.map(costo, CostoDto.class);
    }

    @Override
    public CostoDto createCosto(CreateCostoDto createCostoDto) {
        Vuelo vuelo = vueloRepository.findById(createCostoDto.getFlightId()).orElseThrow(
                () -> new ResourceNotFoundException("Vuelo", "id", createCostoDto.getFlightId())
        );
        Aereolinea aereolinea = aereolineaRepository.findById(createCostoDto.getAirlineId()).orElseThrow(
                () -> new ResourceNotFoundException("Aereolinea", "id", createCostoDto.getAirlineId())
        );
        Costo costo = new Costo();
        costo.setAirline(aereolinea);
        costo.setFlight(vuelo);
        costo.setValidFromDate(createCostoDto.getValidFromDate());
        costo.setValidToDate(createCostoDto.getValidToDate());
        costo.setFlightCost(createCostoDto.getFlightCost());
        return modelMapper.map(costoRepository.save(costo), CostoDto.class);
    }

    @Override
    public CostoDto updateCosto(Long costoId, CreateCostoDto createCostoDto) {
        Costo costo = costoRepository.findById(costoId).orElseThrow(
                () -> new ResourceNotFoundException("Costo", "id", costoId)
        );
        Vuelo vuelo = vueloRepository.findById(createCostoDto.getFlightId()).orElseThrow(
                () -> new ResourceNotFoundException("Vuelo", "id", createCostoDto.getFlightId())
        );
        Aereolinea aereolinea = aereolineaRepository.findById(createCostoDto.getAirlineId()).orElseThrow(
                () -> new ResourceNotFoundException("Aereolinea", "id", createCostoDto.getAirlineId())
        );
        costo.setAirline(aereolinea);
        costo.setFlight(vuelo);
        costo.setValidFromDate(createCostoDto.getValidFromDate());
        costo.setValidToDate(createCostoDto.getValidToDate());
        costo.setFlightCost(createCostoDto.getFlightCost());
        return modelMapper.map(costoRepository.save(costo), CostoDto.class);
    }

    @Override
    public CostoDto deleteCosto(Long costoId) {
        Costo costo = costoRepository.findById(costoId).orElseThrow(
                () -> new ResourceNotFoundException("Costo", "id", costoId)
        );
        costoRepository.deleteById(costoId);
        return modelMapper.map(costo, CostoDto.class);
    }
}
