package com.medicine.demo.service;

import com.medicine.demo.dao.DoctorDAO;
import com.medicine.demo.entity.Doctor;
import com.medicine.demo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoctorDAOImpl implements DoctorDAO
{
   private DoctorRepository doctorRepository;

   @Autowired
    public DoctorDAOImpl(DoctorRepository doctorRepository)
    {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> getAllDoctors() {

        return doctorRepository.findAll();
    }

    @Override
    public Doctor findById(UUID id)
    {
        Optional<Doctor> result=doctorRepository.findById(id);
        Doctor doctor=null;
        if (result.isPresent())
        {
            doctor=result.get();
        }
        else
        {
            throw new RuntimeException("does not exit");
        }
        return doctor;
    }

    @Override
    public void save(Doctor doctor)
    {
       doctorRepository.save(doctor);
    }

    @Override
    public void deleteById(UUID id)
    {
      doctorRepository.deleteById(id);
    }
}
