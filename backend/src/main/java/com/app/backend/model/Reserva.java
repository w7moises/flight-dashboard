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
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservation_id;

    @Column(name = "agent_id", nullable = false)
    private Long agent_id;

    @Column(name = "flight_id", nullable = false)
    private Long passenger_id;

    @Enumerated(EnumType.STRING)
    private Status reservation_status_code;

    @Column(name = "ticket_code", nullable = false, length = 6)
    private String ticket_code;

    @Enumerated(EnumType.STRING)
    private Type travel_type_class;

    @Column(name = "reservation_date", nullable = false)
    private Date reservation_date;

    @Column(name = "number_in_party", nullable = false)
    private Long number_in_party;
}
