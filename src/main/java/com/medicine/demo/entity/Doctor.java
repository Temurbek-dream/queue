package com.medicine.demo.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.medicine.demo.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "doctor")
public class Doctor extends AbsEntity
{
    @Column(nullable = false)
    @NotBlank
    private String occupation;


    @Column(nullable = false)
    private String description;
}
