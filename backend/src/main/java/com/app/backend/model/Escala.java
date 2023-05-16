package com.app.backend.model;

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
    private Long leg_id;

    @ManyToOne
    private Vuelo flight;

    @OneToOne
    private Aereopuerto origin_airport;

    @OneToOne
    private Aereopuerto destination_airport;

    @Column(name = "actual_departure_time", nullable = false)
    private Date actual_departure_time;

    @Column(name = "actual_arrival_time", nullable = false)
    private Date actual_arrival_time;
}
