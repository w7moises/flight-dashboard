package com.app.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aereopuertos")
public class Aereopuerto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airport_id", nullable = false)
    private Long airportId;

    @Column(name = "airport_name", nullable = false)
    private String airportName;

    @Column(name = "airport_location", nullable = false)
    private String airportLocation;

    @Column(name = "other_details", nullable = false)
    private String otherDetails;
}
