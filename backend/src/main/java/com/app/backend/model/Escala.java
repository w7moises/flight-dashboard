package com.app.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

public class Escala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leg_id;

    @Column(name = "flight_id", nullable = false)
    private Long flight_id;

    @Column(name = "origin_airport_id", nullable = false)
    private Long origin_airport_id;

    @Column(name = "destination_airport_id", nullable = false)
    private Long destination_airport_id;

    @Column(name = "actual_departure_time", nullable = false)
    private Date actual_departure_time;

    @Column(name = "actual_arrival_time", nullable = false)
    private Date actual_arrival_time;
}
