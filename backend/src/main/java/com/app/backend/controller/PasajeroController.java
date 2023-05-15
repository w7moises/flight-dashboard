package com.app.backend.controller;

import com.app.backend.dto.PasajeroDto;
import com.app.backend.service.PasajeroService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/pasajeros")
public class PasajeroController {

    private final PasajeroService pasajeroService;

    public PasajeroController(PasajeroService pasajeroService) {
        this.pasajeroService = pasajeroService;
    }

    @GetMapping("/page")
    public ResponseEntity<Page<PasajeroDto>> getAllPasajeros(Pageable pageable) {
        Page<PasajeroDto> pasajeroList = pasajeroService.getAllPasajeros(pageable);
        return new ResponseEntity<>(pasajeroList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PasajeroDto> getPasajeroById(@PathVariable Long id) {
        PasajeroDto pasajero = pasajeroService.getPasajeroById(id);
        return new ResponseEntity<>(pasajero, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PasajeroDto> createPasajero(@RequestBody @Valid PasajeroDto pasajeroDto) {
        PasajeroDto pasajero = pasajeroService.createPasajero(pasajeroDto);
        return new ResponseEntity<>(pasajero, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PasajeroDto> updatePasajero(@PathVariable Long id, @RequestBody @Valid PasajeroDto pasajeroDto) {
        PasajeroDto pasajero = pasajeroService.updatePasajero(id, pasajeroDto);
        return new ResponseEntity<>(pasajero, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PasajeroDto> deletePasajero(@PathVariable Long id) {
        PasajeroDto pasajero = pasajeroService.deletePasajero(id);
        return new ResponseEntity<>(pasajero, HttpStatus.OK);
    }
}
