package com.app.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "aviones")
public class Avion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aircraft_id;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String maker;

    @Column(nullable = false)
    private Long capacity;
}
