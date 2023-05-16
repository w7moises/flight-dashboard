package com.app.backend.service.impl;

import com.app.backend.dto.PasajeroDto;
import com.app.backend.dto.UserDto;
import com.app.backend.exception.ResourceNotFoundException;
import com.app.backend.model.Pasajero;
import com.app.backend.model.Role;
import com.app.backend.repository.PasajeroRepository;
import com.app.backend.service.PasajeroService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasajeroServiceImpl implements PasajeroService {

    private final PasajeroRepository pasajeroRepository;

    private final AuthenticationServiceImpl authenticationServiceImpl;
    private final ModelMapper modelMapper;

    public PasajeroServiceImpl(PasajeroRepository pasajeroRepository, AuthenticationServiceImpl authenticationServiceImpl, ModelMapper modelMapper) {
        this.pasajeroRepository = pasajeroRepository;
        this.authenticationServiceImpl = authenticationServiceImpl;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<PasajeroDto> getAllPasajeros(Pageable pageable) {
        return pasajeroRepository.findAll(pageable).map(pasajero -> modelMapper.map(pasajero, PasajeroDto.class));
    }

    @Override
    public List<PasajeroDto> getAllPasajeros() {
        return pasajeroRepository.findAll().stream().map(pasajero -> modelMapper.map(pasajero, PasajeroDto.class)).toList();
    }

    @Override
    public PasajeroDto getPasajeroById(Long pasajeroId) {
        Pasajero optionalPasajero = pasajeroRepository.findById(pasajeroId).orElseThrow(
                () -> new ResourceNotFoundException("Pasajero", "id", pasajeroId)
        );
        return modelMapper.map(optionalPasajero, PasajeroDto.class);
    }

    @Override
    public PasajeroDto createPasajero(PasajeroDto pasajeroDto) {
        Pasajero pasajero = pasajeroRepository.save(modelMapper.map(pasajeroDto, Pasajero.class));
        UserDto userDto = new UserDto();
        userDto.setEmail(pasajero.getEmail_address());
        userDto.setFirstName(pasajero.getFirst_name());
        userDto.setLastName(pasajero.getLast_name());
        userDto.setPassword(pasajero.getEmail_address());
        authenticationServiceImpl.register(userDto, Role.ROLE_PASSENGER);
        return modelMapper.map(pasajero, PasajeroDto.class);
    }

    @Override
    public PasajeroDto updatePasajero(Long pasajeroId, PasajeroDto pasajeroDto) {
        Pasajero optionalPasajero = pasajeroRepository.findById(pasajeroId).orElseThrow(
                () -> new ResourceNotFoundException("Pasajero", "id", pasajeroId)
        );
        optionalPasajero.setFirst_name(pasajeroDto.getFirst_name());
        optionalPasajero.setSecond_name(pasajeroDto.getSecond_name());
        optionalPasajero.setLast_name(pasajeroDto.getLast_name());
        optionalPasajero.setPhone_number(pasajeroDto.getPhone_number());
        optionalPasajero.setEmail_address(pasajeroDto.getEmail_address());
        optionalPasajero.setCity(pasajeroDto.getCity());
        optionalPasajero.setCountry(pasajeroDto.getCountry());
        optionalPasajero.setOther_details(pasajeroDto.getOther_details());
        return modelMapper.map(pasajeroRepository.save(optionalPasajero), PasajeroDto.class);
    }

    @Override
    public PasajeroDto deletePasajero(Long pasajeroId) {
        Pasajero optionalPasajero = pasajeroRepository.findById(pasajeroId).orElseThrow(
                () -> new ResourceNotFoundException("Pasajero", "id", pasajeroId)
        );
        pasajeroRepository.deleteById(pasajeroId);
        return modelMapper.map(optionalPasajero, PasajeroDto.class);
    }
}
