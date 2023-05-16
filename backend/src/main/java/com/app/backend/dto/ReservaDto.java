package com.app.backend.dto;

import com.app.backend.model.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
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

    private Long reservation_id;

    private Agente agent;

    private Pasajero passenger;

    private Status reservation_status_code;

    private String ticket_code;

    private Type travel_type_class;

    private Long number_in_party;

    private Escala leg;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date reservation_date;
}
