package com.app.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

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

    @ManyToOne
    private Agente agent;

    @ManyToOne
    private Pasajero passenger;

    @Enumerated(EnumType.STRING)
    private Status reservation_status_code;

    @Column(name = "ticket_code", nullable = false, length = 6)
    private String ticket_code;

    @Enumerated(EnumType.STRING)
    private Type travel_type_class;

    @Column(name = "reservation_date", nullable = false)
    @CreationTimestamp
    private Date reservation_date;

    @Column(name = "number_in_party", nullable = false)
    private Long number_in_party;

    @OneToOne
    private Escala leg;
}
