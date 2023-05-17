package com.app.backend.dto;

import com.app.backend.model.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDto {

    private Long reservationId;

    private Agente agent;

    private Pasajero passenger;

    private Status reservationStatusCode;

    private String ticketCode;

    private Type travelTypeClass;

    private Long numberInParty;

    private Escala leg;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date reservationDate;
}
