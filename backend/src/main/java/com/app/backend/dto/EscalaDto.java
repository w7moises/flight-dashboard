package com.app.backend.dto;

import com.app.backend.model.Aereopuerto;
import com.app.backend.model.Vuelo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EscalaDto {

    private Long leg_id;

    private Vuelo flight;

    private Aereopuerto origin_airport;

    private Aereopuerto destination_airport;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date actual_departure_date;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date actual_arrival_date;

    @NotBlank(message = "departure_time is required")
    private String actual_departure_time;

    @NotBlank(message = "arrival_time is required")
    private String actual_arrival_time;
}
