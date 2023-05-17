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
    @Column(name = "reservation_id", nullable = false)
    private Long reservationId;

    @ManyToOne
    private Agente agent;

    @ManyToOne
    private Pasajero passenger;

    @Enumerated(EnumType.STRING)
    @Column(name = "reservation_status_code", nullable = false)
    private Status reservationStatusCode;

    @Column(name = "ticket_code", nullable = false, length = 6)
    private String ticketCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "travel_type_class", nullable = false)
    private Type travelTypeClass;

    @Column(name = "reservation_date", nullable = false)
    @CreationTimestamp
    private Date reservationDate;

    @Column(name = "number_in_party", nullable = false)
    private Long numberInParty;

    @OneToOne
    private Escala leg;
}
