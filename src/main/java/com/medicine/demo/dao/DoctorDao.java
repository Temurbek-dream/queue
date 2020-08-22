package com.medicine.demo.dao;

import com.medicine.demo.entity.Doctor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DoctorDao
{
    int insertPerson(Doctor doctor);
     List<Doctor> selectAllDoctors();
     Optional<Doctor>selectDoctorById(UUID id);
     int deleteDoctorById(UUID id);
     int updateDoctorById(UUID id,Doctor doctor);
}
