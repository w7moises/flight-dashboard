package com.app.backend.dto.create;

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

    private Long flightId;

    private Long airlineId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date validFromDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date validToDate;

    private BigDecimal flightCost;
}
