package com.app.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pagos")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payment_id;

    @OneToOne
    private Reserva reservation;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "payment_date", nullable = false)
    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date payment_date;

    @Column(name = "payment_amount", nullable = false)
    private BigDecimal payment_amount;
}
