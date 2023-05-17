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
        userDto.setEmail(pasajero.getEmailAddress());
        userDto.setFirstName(pasajero.getFirstName());
        userDto.setLastName(pasajero.getLastName());
        userDto.setPassword(pasajero.getEmailAddress());
        authenticationServiceImpl.register(userDto, Role.ROLE_PASSENGER);
        return modelMapper.map(pasajero, PasajeroDto.class);
    }

    @Override
    public PasajeroDto updatePasajero(Long pasajeroId, PasajeroDto pasajeroDto) {
        Pasajero optionalPasajero = pasajeroRepository.findById(pasajeroId).orElseThrow(
                () -> new ResourceNotFoundException("Pasajero", "id", pasajeroId)
        );
        optionalPasajero.setFirstName(pasajeroDto.getFirstName());
        optionalPasajero.setSecondName(pasajeroDto.getSecondName());
        optionalPasajero.setLastName(pasajeroDto.getLastName());
        optionalPasajero.setPhoneNumber(pasajeroDto.getPhoneNumber());
        optionalPasajero.setEmailAddress(pasajeroDto.getEmailAddress());
        optionalPasajero.setCity(pasajeroDto.getCity());
        optionalPasajero.setCountry(pasajeroDto.getCountry());
        optionalPasajero.setOtherDetails(pasajeroDto.getOtherDetails());
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
