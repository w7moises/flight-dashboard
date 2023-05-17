package com.app.backend.dto;

import com.app.backend.model.Aereolinea;
import com.app.backend.model.Vuelo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
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
public class CostoDto {

    private Long costId;

    private Vuelo flight;

    private Aereolinea airline;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date validFromDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date validToDate;

    private BigDecimal flightCost;
}
