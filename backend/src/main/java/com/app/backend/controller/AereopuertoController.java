package com.app.backend.controller;

import com.app.backend.dto.AereopuertoDto;
import com.app.backend.service.AereopuertoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/aereopuertos")
public class AereopuertoController {

    private final AereopuertoService aereopuertoService;

    public AereopuertoController(AereopuertoService aereopuertoService) {
        this.aereopuertoService = aereopuertoService;
    }

    @GetMapping("/page")
    public ResponseEntity<Page<AereopuertoDto>> getAllAereopuertos(Pageable pageable) {
        Page<AereopuertoDto> aereopuertoList = aereopuertoService.getAereopuertos(pageable);
        return new ResponseEntity<>(aereopuertoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AereopuertoDto> getAereopuertoById(@PathVariable Long id) {
        AereopuertoDto aereopuerto = aereopuertoService.getAereopuertoById(id);
        return new ResponseEntity<>(aereopuerto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AereopuertoDto> createAereopuerto(@RequestBody @Valid AereopuertoDto aereopuertoDto) {
        AereopuertoDto aereopuerto = aereopuertoService.createAereopuerto(aereopuertoDto);
        return new ResponseEntity<>(aereopuerto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AereopuertoDto> updateAereopuerto(@PathVariable Long id, @RequestBody @Valid AereopuertoDto aereopuertoDto) {
        AereopuertoDto aereopuerto = aereopuertoService.updateAereopuerto(id, aereopuertoDto);
        return new ResponseEntity<>(aereopuerto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AereopuertoDto> deleteAereopuerto(@PathVariable Long id) {
        AereopuertoDto aereopuerto = aereopuertoService.deleteAereopuerto(id);
        return new ResponseEntity<>(aereopuerto, HttpStatus.OK);
    }
}
