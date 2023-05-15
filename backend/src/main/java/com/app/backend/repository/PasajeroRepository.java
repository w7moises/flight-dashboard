package com.app.backend.repository;

import com.app.backend.model.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero, Long>, PagingAndSortingRepository<Pasajero, Long> {
}
