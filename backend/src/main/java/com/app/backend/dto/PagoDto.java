package com.app.backend.dto;

import com.app.backend.model.Reserva;
import com.app.backend.model.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagoDto {

    private Long payment_id;

    private Reserva reservation;

    private Status status;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date payment_date;

    private BigDecimal payment_amount;
}
