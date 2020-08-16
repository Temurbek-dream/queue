package com.medicine.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Doctor
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String nameDoctor;

    private String occupation;

    private int number;


}
