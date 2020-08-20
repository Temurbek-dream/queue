package com.medicine.demo.service;

import com.medicine.demo.entity.Doctor;
import com.medicine.demo.repository.DoctorRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CountService
{
    private final DoctorRepository doctorRepository;

    public CountService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    private int k=0;
    public HttpEntity<?> countt(UUID id)
    {
        Doctor doctor1=doctorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id+"This kind of user not found"));
        Optional<Doctor> doctor= doctorRepository.findById(id);
      if (doctor.isPresent())
      {
          k++;
      }
          doctor1.setCounting(k);
      return ResponseEntity.status(HttpStatus.ACCEPTED).body(k);
    }
}
