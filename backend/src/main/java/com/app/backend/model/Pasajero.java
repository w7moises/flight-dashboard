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
@Table(name = "pasajeros")
public class Pasajero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passenger_id;

    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Column(name = "second_name", nullable = false)
    private String second_name;

    @Column(name = "last_name", nullable = false)
    private String last_name;

    @Column(name = "phone_number", nullable = false)
    private String phone_number;

    @Column(name = "email_address", nullable = false)
    private String email_address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    @Column(name = "other_details", nullable = false)
    private String other_details;
}
