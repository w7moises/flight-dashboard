package com.app.backend.repository;

import com.app.backend.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>, PagingAndSortingRepository<Reserva, Long> {
    List<Reserva> findByPassenger_EmailAddress(String email_address);
}
