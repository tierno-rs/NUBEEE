package com.cafe.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.main.models.ExamenModel;
import com.cafe.main.services.ExamenService;

@CrossOrigin
@RestController
@RequestMapping(path = "/examen")
public class ExamenController {
    @Autowired
    private ExamenService examenService;

    @GetMapping("/getAll")
    public List<ExamenModel> getAll(){
        return examenService.getAll();
    }


    @PostMapping("/save")
    public ExamenModel save(@RequestBody ExamenModel data) {
        return examenService.create(data);
    }

    @PutMapping("/update/{id}")
    public ExamenModel update(@PathVariable int id, @RequestBody ExamenModel data) {
        return examenService.update(id, data);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        examenService.delete(id);
    }
}
