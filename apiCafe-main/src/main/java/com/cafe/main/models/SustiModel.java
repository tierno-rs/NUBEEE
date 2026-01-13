package com.cafe.main.models;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "t_susti")
public class SustiModel {
    @Id
    private String dni;
    @Column
    private String name;
    @Column
    private String surName;
    @Column
    private int year;
    @Column
    private LocalDate birthDate;
}
