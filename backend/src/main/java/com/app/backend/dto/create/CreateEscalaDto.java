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

    private Long flight_id;

    private Long origin_airport_id;

    private Long destination_airport_id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date actual_departure_date;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date actual_arrival_date;

    @NotBlank(message = "departure_time is required")
    private String actual_departure_time;

    @NotBlank(message = "arrival_time is required")
    private String actual_arrival_time;
}
