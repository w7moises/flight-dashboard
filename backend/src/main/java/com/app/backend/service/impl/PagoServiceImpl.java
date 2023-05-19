package com.app.backend.service.impl;

import com.app.backend.dto.PagoDto;
import com.app.backend.dto.create.CreatePagoDto;
import com.app.backend.exception.ResourceNotFoundException;
import com.app.backend.model.Pago;
import com.app.backend.model.Reserva;
import com.app.backend.model.Status;
import com.app.backend.repository.PagoRepository;
import com.app.backend.repository.ReservaRepository;
import com.app.backend.service.PagoService;
import org.modelmapper.ModelMapper;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoServiceImpl implements PagoService {

    private final PagoRepository pagoRepository;

    private final JavaMailSender mailSender;

    private final ReservaRepository reservaRepository;

    private final ModelMapper modelMapper;

    public PagoServiceImpl(PagoRepository pagoRepository, JavaMailSender mailSender, ReservaRepository reservaRepository, ModelMapper modelMapper) {
        this.pagoRepository = pagoRepository;
        this.mailSender = mailSender;
        this.reservaRepository = reservaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PagoDto> getAllPagos() {
        return pagoRepository.findAll().stream().map(data -> modelMapper.map(data, PagoDto.class)).toList();
    }

    @Override
    public PagoDto createPago(CreatePagoDto createPagoDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("fromemail@gmail.com");
        message.setTo("w7moises@gmail.com");
        message.setText(createPagoDto.getReservationId() + "#fa345s1d1gsa12591" + createPagoDto.getPaymentAmount());
        message.setSubject("token");
        mailSender.send(message);
        Reserva reserva = reservaRepository.findById(createPagoDto.getReservationId()).orElseThrow(
                () -> new ResourceNotFoundException("Reserva", "id", createPagoDto.getReservationId())
        );
        reserva.setReservationStatusCode(Status.TERMINADO);
        Pago pago = new Pago();
        pago.setReservation(reserva);
        pago.setStatus(Status.TERMINADO);
        pago.setPaymentAmount(createPagoDto.getPaymentAmount());
        reservaRepository.save(reserva);
        return modelMapper.map(pagoRepository.save(pago), PagoDto.class);
    }
}
