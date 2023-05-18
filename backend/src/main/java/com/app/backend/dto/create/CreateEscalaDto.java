package com.app.backend.dto.create;

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
public class CreateEscalaDto {

    private Long flightId;

    private Long originAirportId;

    private Long destinationAirportId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date actualDepartureDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date actualArrivalDate;

    @NotBlank(message = "departure_time is required")
    private String actualDepartureTime;

    @NotBlank(message = "arrival_time is required")
    private String actualArrivalTime;
}
