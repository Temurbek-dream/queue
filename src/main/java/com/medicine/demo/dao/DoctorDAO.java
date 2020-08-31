package com.medicine.demo.dao;


import com.medicine.demo.entity.Doctor;

import java.util.List;
import java.util.UUID;

public interface DoctorDAO
{
    List<Doctor> getAllDoctors();
    Doctor findById(UUID id);
    void save(Doctor doctor);
    void deleteById(UUID id);
}
