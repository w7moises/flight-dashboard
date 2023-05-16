package com.app.backend.repository;

import com.app.backend.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long>, PagingAndSortingRepository<Pago, Long> {
}
