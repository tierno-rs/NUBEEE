package com.cafe.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.main.models.ExamenModel;
import com.cafe.main.repositories.ExamenRepository;

@Service
public class ExamenService {
    @Autowired
    private ExamenRepository examenRepository;

    public List<ExamenModel> getAll(){
        return examenRepository.findAll();
    }
    public ExamenModel create(ExamenModel examen){
        return examenRepository.save(examen);
    }
    public ExamenModel update(int id, ExamenModel examen){
        ExamenModel existing = examenRepository.findById(id).orElse(null);
        if(existing != null){
            existing.setBrand(examen.getBrand());
            existing.setDescription(examen.getDescription());
            existing.setCountry(examen.getCountry());
            existing.setProductionDate(examen.getProductionDate());
            existing.setExpirationDate(examen.getExpirationDate());
            return examenRepository.save(existing);
        }
        return null;
    }
    public void delete(int id){
        examenRepository.deleteById(id);
    }

  
}
