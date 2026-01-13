package com.cafe.main.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafe.main.models.SustiModel;

public interface SustiRepository extends JpaRepository<SustiModel, Integer> {
    Optional<SustiModel> findByDni(String dni);
    
}
