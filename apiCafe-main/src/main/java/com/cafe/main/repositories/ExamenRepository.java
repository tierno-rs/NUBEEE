package com.cafe.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafe.main.models.ExamenModel;

public interface ExamenRepository extends JpaRepository<ExamenModel, Integer>{
     
}
