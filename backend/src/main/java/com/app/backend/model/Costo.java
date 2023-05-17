package com.app.backend.model;

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
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "costos")
public class Costo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cost_id", nullable = false)
    private Long costId;

    @ManyToOne
    private Vuelo flight;

    @ManyToOne
    private Aereolinea airline;

    @Column(name = "valid_from_date", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date validFromDate;

    @Column(name = "valid_to_date", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date validToDate;

    @Column(name = "flight_cost", nullable = false)
    private BigDecimal flightCost;
}
