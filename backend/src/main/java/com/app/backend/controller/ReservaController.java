package com.app.backend.controller;

import com.app.backend.dto.ReservaDto;
import com.app.backend.dto.create.CreateReservaDto;
import com.app.backend.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/page")
    public ResponseEntity<Page<ReservaDto>> getAllReservas(Pageable pageable) {
        Page<ReservaDto> reservaList = reservaService.getAllReservas(pageable);
        return new ResponseEntity<>(reservaList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDto> getReservaById(@PathVariable Long id) {
        ReservaDto reserva = reservaService.getReservaById(id);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReservaDto> createReserva(@RequestBody @Valid CreateReservaDto reservaDto) {
        ReservaDto reserva = reservaService.createReserva(reservaDto);
        return new ResponseEntity<>(reserva, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaDto> updateReserva(@PathVariable Long id, @RequestBody @Valid CreateReservaDto reservaDto) {
        ReservaDto reserva = reservaService.updateReserva(id, reservaDto);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReservaDto> deleteReserva(@PathVariable Long id) {
        ReservaDto reserva = reservaService.deleteReserva(id);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }
}
