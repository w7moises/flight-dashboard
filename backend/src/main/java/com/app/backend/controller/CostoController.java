package com.app.backend.controller;

import com.app.backend.dto.CostoDto;
import com.app.backend.dto.create.CreateCostoDto;
import com.app.backend.service.CostoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/costos")
public class CostoController {

    private final CostoService costoService;

    public CostoController(CostoService costoService) {
        this.costoService = costoService;
    }

    @GetMapping("/page")
    public ResponseEntity<List<CostoDto>> getAllCostos() {
        List<CostoDto> costoList = costoService.getAllCostos();
        return new ResponseEntity<>(costoList, HttpStatus.OK);
    }

    @GetMapping("/vuelo/{id}")
    public ResponseEntity<List<CostoDto>> getAllCostos(@PathVariable Long id) {
        List<CostoDto> costoList = costoService.getAllCostosByVueloId(id);
        return new ResponseEntity<>(costoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CostoDto> getCostoById(@PathVariable Long id) {
        CostoDto costo = costoService.getCostoById(id);
        return new ResponseEntity<>(costo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CostoDto> createCosto(@RequestBody @Valid CreateCostoDto costoDto) {
        CostoDto costo = costoService.createCosto(costoDto);
        return new ResponseEntity<>(costo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CostoDto> updateCosto(@PathVariable Long id, @RequestBody @Valid CreateCostoDto costoDto) {
        CostoDto costo = costoService.updateCosto(id, costoDto);
        return new ResponseEntity<>(costo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CostoDto> deleteCosto(@PathVariable Long id) {
        CostoDto costo = costoService.deleteCosto(id);
        return new ResponseEntity<>(costo, HttpStatus.OK);
    }
}
