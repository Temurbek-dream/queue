package com.medicine.demo.entity;


import com.medicine.demo.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "doctor")
public class Doctor extends AbsEntity
{
    @Column(unique = true, nullable = false)
    private String occupation;

    @Column(nullable = false)
    private int counting;

}
