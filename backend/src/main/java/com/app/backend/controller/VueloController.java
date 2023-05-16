package com.app.backend.controller;

import com.app.backend.dto.VueloDto;
import com.app.backend.dto.create.CreateVueloDto;
import com.app.backend.model.Aereolinea;
import com.app.backend.model.Avion;
import com.app.backend.service.VueloService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1")
public class VueloController {

    private final VueloService vueloService;

    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    @GetMapping("/vuelos/page")
    public ResponseEntity<Page<VueloDto>> getAllVuelos(Pageable pageable) {
        Page<VueloDto> vueloList = vueloService.getVuelos(pageable);
        return new ResponseEntity<>(vueloList, HttpStatus.OK);
    }

    @GetMapping("/vuelos/{id}")
    public ResponseEntity<VueloDto> getVueloById(@PathVariable Long id) {
        VueloDto vuelo = vueloService.getVueloById(id);
        return new ResponseEntity<>(vuelo, HttpStatus.OK);
    }

    @PostMapping("/vuelos")
    public ResponseEntity<VueloDto> createVuelo(@RequestBody @Valid CreateVueloDto createVueloDto) {
        VueloDto vuelo = vueloService.createVuelo(createVueloDto);
        return new ResponseEntity<>(vuelo, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<VueloDto> updateVuelo(@PathVariable Long id, @RequestBody @Valid CreateVueloDto createVueloDto) {
        VueloDto vuelo = vueloService.updateVuelo(id, createVueloDto);
        return new ResponseEntity<>(vuelo, HttpStatus.OK);
    }

    @DeleteMapping("/vuelos/{id}")
    public ResponseEntity<VueloDto> deleteVuelo(@PathVariable Long id) {
        VueloDto vuelo = vueloService.deleteVuelo(id);
        return new ResponseEntity<>(vuelo, HttpStatus.OK);
    }

    @GetMapping("/aviones")
    public ResponseEntity<List<Avion>> getAllAviones() {
        List<Avion> avionList = vueloService.getAviones();
        return new ResponseEntity<>(avionList, HttpStatus.OK);
    }

    @GetMapping("/aereolineas")
    public ResponseEntity<List<Aereolinea>> getAllAereolineas() {
        List<Aereolinea> aereolineaList = vueloService.getAereolineas();
        return new ResponseEntity<>(aereolineaList, HttpStatus.OK);
    }
}
