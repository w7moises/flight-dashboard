package com.app.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "escalas")
public class Escala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "leg_id", nullable = false)
    private Long legId;

    @ManyToOne
    private Vuelo flight;

    @OneToOne
    private Aereopuerto origin_airport;

    @OneToOne
    private Aereopuerto destination_airport;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date actualDepartureDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date actualArrivalDate;

    @Column(name = "actual_departure_time", nullable = false)
    private String actualDepartureTime;

    @Column(name = "actual_arrival_time", nullable = false)
    private String actualArrivalTime;
}
