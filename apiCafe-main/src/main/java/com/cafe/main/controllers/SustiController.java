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

import com.cafe.main.models.SustiModel;
import com.cafe.main.services.SustiService;

@CrossOrigin
@RestController
@RequestMapping(path = "/susti")
public class SustiController {
    @Autowired
    private SustiService sustiService;

    @GetMapping("/getAll")
    public List<SustiModel> getAll() {
        return sustiService.getAll();
    }

    @PostMapping("/save")
    public SustiModel save(@RequestBody SustiModel sustiModel) {
        return sustiService.create(sustiModel);
    }

    @PutMapping("/update/{id}")
    public SustiModel update(@PathVariable String id, @RequestBody SustiModel sustiModel) {
        return sustiService.update(id, sustiModel);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        sustiService.delete(id);
    }

}
