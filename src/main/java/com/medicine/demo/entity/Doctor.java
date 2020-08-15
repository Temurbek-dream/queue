package com.medicine.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Doctor
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

//    @Column(nullable = false)
    private Long id;

//    @Column(nullable = false)
    private String nameDoctor;

//    @Column(nullable = false)
    private String occupation;

////    @Column(nullable = false)
    private int number;
}
