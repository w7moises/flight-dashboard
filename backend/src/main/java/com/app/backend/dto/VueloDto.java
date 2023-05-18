package com.app.backend.dto;

import com.app.backend.model.Aereolinea;
import com.app.backend.model.Aereopuerto;
import com.app.backend.model.Avion;
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
public class VueloDto {

    private Long flightId;

    private Aereolinea airline;

    private Avion airplane;

    private Aereopuerto origin_airport;

    private Aereopuerto destination_airport;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date departureDate;

    @NotBlank(message = "departure_time is required")
    private String departureTime;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date arrivalDate;

    @NotBlank(message = "arrival_time is required")
    private String arrivalTime;
}
