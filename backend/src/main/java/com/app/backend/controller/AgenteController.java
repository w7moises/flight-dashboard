package com.app.backend.controller;

import com.app.backend.dto.AgenteDto;
import com.app.backend.service.AgenteService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/agentes")
public class AgenteController {

    private final AgenteService agenteService;

    public AgenteController(AgenteService agenteService) {
        this.agenteService = agenteService;
    }

    @GetMapping("/page")
    public ResponseEntity<Page<AgenteDto>> getAllAgentes(Pageable pageable) {
        Page<AgenteDto> agenteList = agenteService.getAllAgentes(pageable);
        return new ResponseEntity<>(agenteList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgenteDto> getAgenteById(@PathVariable Long id) {
        AgenteDto agente = agenteService.getAgenteById(id);
        return new ResponseEntity<>(agente, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AgenteDto> createAgente(@RequestBody @Valid AgenteDto AgentDto) {
        AgenteDto agente = agenteService.createAgente(AgentDto);
        return new ResponseEntity<>(agente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgenteDto> updateAgente(@PathVariable Long id, @RequestBody @Valid AgenteDto AgentDto) {
        AgenteDto agente = agenteService.updateAgente(id, AgentDto);
        return new ResponseEntity<>(agente, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AgenteDto> deleteAgente(@PathVariable Long id) {
        AgenteDto agente = agenteService.deleteAgente(id);
        return new ResponseEntity<>(agente, HttpStatus.OK);
    }
}
