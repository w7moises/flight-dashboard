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
    private Long airport_id;

    @Column(name = "airport_name", nullable = false)
    private String airport_name;

    @Column(name = "airport_location", nullable = false)
    private String airport_location;

    @Column(name = "other_details", nullable = false)
    private String other_details;
}
