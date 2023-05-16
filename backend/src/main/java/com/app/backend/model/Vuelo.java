package com.app.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vuelos")
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flight_id;

    @OneToOne
    private Aereolinea airline;

    @ManyToOne
    private Avion airplane;

    @ManyToOne
    private Aereopuerto origin_airport;

    @ManyToOne
    private Aereopuerto destination_airport;

    @Column(name = "departure_date", nullable = false)
    private Date departure_date;

    @Column(name = "departure_time", nullable = false)
    private String departure_time;

    @Column(name = "arrival_date", nullable = false)
    private Date arrival_date;

    @Column(name = "arrival_time", nullable = false)
    private String arrival_time;
}
