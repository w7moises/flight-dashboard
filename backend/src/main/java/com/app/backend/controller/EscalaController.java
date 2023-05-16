package com.app.backend.controller;

import com.app.backend.dto.EscalaDto;
import com.app.backend.dto.create.CreateEscalaDto;
import com.app.backend.service.EscalaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/escalas")
public class EscalaController {

    private final EscalaService escalaService;

    public EscalaController(EscalaService service) {
        this.escalaService = service;
    }

    @GetMapping
    public ResponseEntity<List<EscalaDto>> getAllEscalas() {
        List<EscalaDto> escalaList = escalaService.getAllEscalas();
        return new ResponseEntity<>(escalaList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EscalaDto> getEscalaById(@PathVariable Long id) {
        EscalaDto escala = escalaService.getEscalaById(id);
        return new ResponseEntity<>(escala, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EscalaDto> createEscala(@RequestBody @Valid CreateEscalaDto escalaDto) {
        EscalaDto escala = escalaService.createEscala(escalaDto);
        return new ResponseEntity<>(escala, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EscalaDto> updateEscala(@PathVariable Long id, @RequestBody @Valid CreateEscalaDto escalaDto) {
        EscalaDto escala = escalaService.updateEscala(id, escalaDto);
        return new ResponseEntity<>(escala, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EscalaDto> deleteEscala(@PathVariable Long id) {
        EscalaDto escala = escalaService.deleteEscala(id);
        return new ResponseEntity<>(escala, HttpStatus.OK);
    }
}
