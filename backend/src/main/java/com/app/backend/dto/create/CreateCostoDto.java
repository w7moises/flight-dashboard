package com.app.backend.dto.create;

import com.app.backend.model.Aereolinea;
import com.app.backend.model.Vuelo;
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
public class CreateCostoDto {

    private Long flight_id;

    private Long airline_id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date valid_from_date;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date valid_to_date;

    private BigDecimal flight_cost;
}
