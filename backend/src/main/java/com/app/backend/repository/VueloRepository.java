package com.app.backend.repository;

import com.app.backend.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long>, PagingAndSortingRepository<Vuelo, Long> {
}
