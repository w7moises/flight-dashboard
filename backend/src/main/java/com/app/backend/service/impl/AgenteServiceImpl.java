package com.app.backend.service.impl;

import com.app.backend.dto.AgenteDto;
import com.app.backend.exception.ResourceNotFoundException;
import com.app.backend.model.Agente;
import com.app.backend.repository.AgenteRepository;
import com.app.backend.service.AgenteService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AgenteServiceImpl implements AgenteService {

    private final AgenteRepository agenteRepository;

    private final ModelMapper modelMapper;

    public AgenteServiceImpl(AgenteRepository agenteRepository, ModelMapper modelMapper) {
        this.agenteRepository = agenteRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<AgenteDto> getAllAgentes(Pageable pageable) {
        return agenteRepository.findAll(pageable).map(agente -> modelMapper.map(agente, AgenteDto.class));
    }

    @Override
    public AgenteDto getAgenteById(Long agenteId) {
        Agente optionalAgente = agenteRepository.findById(agenteId).orElseThrow(
                () -> new ResourceNotFoundException("Agente", "id", agenteId)
        );
        return modelMapper.map(optionalAgente, AgenteDto.class);
    }

    @Override
    public AgenteDto createAgente(AgenteDto agenteDto) {
        Agente agente = agenteRepository.save(modelMapper.map(agenteDto, Agente.class));
        return modelMapper.map(agente, AgenteDto.class);
    }

    @Override
    public AgenteDto updateAgente(Long agenteId, AgenteDto agenteDto) {
        Agente optionalAgente = agenteRepository.findById(agenteId).orElseThrow(
                () -> new ResourceNotFoundException("Agente", "id", agenteId)
        );
        optionalAgente.setAgent_name(agenteDto.getAgent_name());
        optionalAgente.setAgent_details(agenteDto.getAgent_details());
        return modelMapper.map(agenteRepository.save(optionalAgente), AgenteDto.class);
    }

    @Override
    public AgenteDto deleteAgente(Long agenteId) {
        Agente optionalAgente = agenteRepository.findById(agenteId).orElseThrow(
                () -> new ResourceNotFoundException("Agente", "id", agenteId)
        );
        agenteRepository.delete(optionalAgente);
        return modelMapper.map(optionalAgente, AgenteDto.class);
    }
}
