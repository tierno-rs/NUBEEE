package com.cafe.main.models;

import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "t_examen")
public class ExamenModel {
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String description;
    @Column
    private String brand;
    @Column
    private String country;
    @Column
    private Date expirationDate;
    @Column
    private Date productionDate;
}
