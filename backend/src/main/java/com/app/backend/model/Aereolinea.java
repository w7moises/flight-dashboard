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
@Table(name = "aereolineas")
public class Aereolinea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airline_id;

    @Column(name = "airline_name", nullable = false)
    private String airlineName;

    @Column(name = "airline_code", nullable = false)
    private String airlineCode;
}
