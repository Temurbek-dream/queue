package com.medicine.demo.service;

import com.medicine.demo.dao.DoctorDao;
import com.medicine.demo.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoctorService
{
    private final DoctorDao doctorDao;

    @Autowired
    public DoctorService(@Qualifier("fake") DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

   public int AddDoctor(Doctor doctor)
   {
      return doctorDao.insertPerson(doctor);
   }

   public List<Doctor> getAllDoctors()
   {
      return doctorDao.selectAllDoctors();
   }

   public Optional<Doctor> getDoctorsById(UUID id)
   {
       return doctorDao.selectDoctorById(id);
   }

   public int deleteByIDD(UUID id)
   {
       return doctorDao.deleteDoctorById(id);
   }

   public int updateDoctor(UUID id,Doctor doctor)
   {
       return doctorDao.updateDoctorById(id,doctor);
   }

}
