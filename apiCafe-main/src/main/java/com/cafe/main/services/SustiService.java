package com.cafe.main.services;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.main.models.SustiModel;
import com.cafe.main.repositories.SustiRepository;

@Service
public class SustiService {
    @Autowired
    private SustiRepository sustiRepository;

    public List<SustiModel> getAll() {
        return sustiRepository.findAll();
    }

    public SustiModel create(SustiModel examen) {
        LocalDate birthDate = examen.getBirthDate();

        int age = Period.between(birthDate, LocalDate.now()).getYears();

        examen.setYear(age);

        return sustiRepository.save(examen);
    }

    public SustiModel update(String dni, SustiModel examen) {
        SustiModel existing = sustiRepository.findByDni(dni).orElse(null);

        if (existing != null) {
            existing.setName(examen.getName());
            existing.setSurName(examen.getSurName());
            existing.setBirthDate(examen.getBirthDate());
            existing.setDni(examen.getDni());
            LocalDate birthDate = examen.getBirthDate();
            int age = Period.between(birthDate, LocalDate.now()).getYears();
            existing.setYear(age);

            return sustiRepository.save(existing);
        }

        return null;
    }

    public void delete(String id) {
        SustiModel existing = sustiRepository.findByDni(id).orElse(null);
    
        if (existing != null) {
            sustiRepository.delete(existing); }
    }
}
