package com.app.backend.repository;

import com.app.backend.model.Agente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenteRepository extends JpaRepository<Agente, Long>, PagingAndSortingRepository<Agente, Long> {
}
