package com.app.backend.repository;

import com.app.backend.model.Aereopuerto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AereopuertoRepository extends JpaRepository<Aereopuerto, Long>, PagingAndSortingRepository<Aereopuerto, Long> {
}
