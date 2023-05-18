package com.app.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @Column(name = "flight_id", nullable = false)
    private Long flightId;

    @OneToOne
    private Aereolinea airline;

    @ManyToOne
    private Avion airplane;

    @ManyToOne
    private Aereopuerto origin_airport;

    @ManyToOne
    private Aereopuerto destination_airport;

    @Column(name = "departure_date", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date departureDate;

    @Column(name = "departure_time", nullable = false)
    private String departureTime;

    @Column(name = "arrival_date", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date arrivalDate;

    @Column(name = "arrival_time", nullable = false)
    private String arrivalTime;
}
