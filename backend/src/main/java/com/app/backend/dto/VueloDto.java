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
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VueloDto {

    private Long flight_id;

    private Aereolinea airline;

    private Avion airplane;

    private Aereopuerto origin_airport;

    private Aereopuerto destination_airport;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date departure_date;

    @NotBlank(message = "departure_time is required")
    private String departure_time;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date arrival_date;

    @NotBlank(message = "arrival_time is required")
    private String arrival_time;
}
