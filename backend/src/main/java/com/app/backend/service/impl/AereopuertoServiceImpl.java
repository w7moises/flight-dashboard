package com.app.backend.service.impl;

import com.app.backend.dto.AereopuertoDto;
import com.app.backend.exception.ResourceNotFoundException;
import com.app.backend.model.Aereopuerto;
import com.app.backend.repository.AereopuertoRepository;
import com.app.backend.service.AereopuertoService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AereopuertoServiceImpl implements AereopuertoService {

    private final AereopuertoRepository aereopuertoRepository;

    private final ModelMapper modelMapper;

    public AereopuertoServiceImpl(AereopuertoRepository aereopuertoRepository, ModelMapper modelMapper) {
        this.aereopuertoRepository = aereopuertoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<AereopuertoDto> getAereopuertos(Pageable pageable) {
        return aereopuertoRepository.findAll(pageable).map(aereopuerto -> modelMapper.map(aereopuerto, AereopuertoDto.class));
    }

    @Override
    public AereopuertoDto getAereopuertoById(Long aereopuertoId) {
        Aereopuerto optionalAereopuerto = aereopuertoRepository.findById(aereopuertoId).orElseThrow(
                () -> new ResourceNotFoundException("Aereopuerto", "id", aereopuertoId)
        );
        return modelMapper.map(optionalAereopuerto, AereopuertoDto.class);
    }

    @Override
    public AereopuertoDto createAereopuerto(AereopuertoDto aereopuertoDto) {
        Aereopuerto aereopuerto = aereopuertoRepository.save(modelMapper.map(aereopuertoDto, Aereopuerto.class));
        return modelMapper.map(aereopuerto, AereopuertoDto.class);
    }

    @Override
    public AereopuertoDto updateAereopuerto(Long aereopuertoId, AereopuertoDto aereopuertoDto) {
        Aereopuerto optionalAereopuerto = aereopuertoRepository.findById(aereopuertoId).orElseThrow(
                () -> new ResourceNotFoundException("Aereopuerto", "id", aereopuertoId)
        );
        optionalAereopuerto.setAirportName(aereopuertoDto.getAirportName());
        optionalAereopuerto.setAirportLocation(aereopuertoDto.getAirportLocation());
        optionalAereopuerto.setOtherDetails(aereopuertoDto.getOtherDetails());
        return modelMapper.map(aereopuertoRepository.save(optionalAereopuerto), AereopuertoDto.class);
    }

    @Override
    public AereopuertoDto deleteAereopuerto(Long aereopuertoId) {
        Aereopuerto optionalAereopuerto = aereopuertoRepository.findById(aereopuertoId).orElseThrow(
                () -> new ResourceNotFoundException("Aereopuerto", "id", aereopuertoId)
        );
        aereopuertoRepository.delete(optionalAereopuerto);
        return modelMapper.map(optionalAereopuerto, AereopuertoDto.class);
    }
}
