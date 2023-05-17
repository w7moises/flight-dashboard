package com.app.backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AereopuertoDto {

    private Long airportId;

    @NotBlank(message = "El nombre del aeropuerto es requerido")
    private String airportName;

    @NotBlank(message = "La ubicación del aeropuerto es requerida")
    private String airportLocation;

    @NotBlank(message = "Los detalles del aeropuerto son requeridos")
    private String otherDetails;
}
