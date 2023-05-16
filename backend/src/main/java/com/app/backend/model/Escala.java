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
    private Long leg_id;

    @ManyToOne
    private Vuelo flight;

    @OneToOne
    private Aereopuerto origin_airport;

    @OneToOne
    private Aereopuerto destination_airport;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date actual_departure_date;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date actual_arrival_date;

    @Column(name = "actual_departure_time", nullable = false)
    private String actual_departure_time;

    @Column(name = "actual_arrival_time", nullable = false)
    private String actual_arrival_time;
}
