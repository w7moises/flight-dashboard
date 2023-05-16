package com.app.backend.controller;

import com.app.backend.dto.PagoDto;
import com.app.backend.dto.create.CreatePagoDto;
import com.app.backend.service.PagoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping
    public ResponseEntity<List<PagoDto>> getAllPagos() {
        List<PagoDto> pagoList = pagoService.getAllPagos();
        return new ResponseEntity<>(pagoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PagoDto> createPago(@RequestBody @Valid CreatePagoDto pagoDto) {
        PagoDto pago = pagoService.createPago(pagoDto);
        return new ResponseEntity<>(pago, HttpStatus.CREATED);
    }
}
