package com.medicine.demo.repository;

import com.medicine.demo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long>
{
//    Optional<Doctor> findAllByName(final String docName);
      Doctor findByNameDoctor(String docName);
}

