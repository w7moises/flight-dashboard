package com.app.backend.dto.create;

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
public class CreateVueloDto {

    private Long airline_id;

    private Long airplane_id;

    private Long origin_airport_id;

    private Long destination_airport_id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date departure_date;

    @NotBlank(message = "departure_time is required")
    private String departure_time;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date arrival_date;

    @NotBlank(message = "arrival_time is required")
    private String arrival_time;
}
