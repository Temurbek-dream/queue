package com.medicine.demo.controller;

import com.medicine.demo.entity.Doctor;
import com.medicine.demo.repository.DoctorRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DoctorController
{
    private int counting=0;
    private final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository)
    {
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("/all")
    public List<Doctor> getAllDoctors()
    {
        return doctorRepository.findAll();
    }
    @PostMapping("/add")
    public ResponseEntity<String> addDoctors(@RequestBody Doctor doctor)
    {
        doctorRepository.save(doctor);
        return  new ResponseEntity<>("New doctor is added", HttpStatus.CREATED);
    }
    @GetMapping("/all/{id}")
    public Optional<Doctor> findDoctor(@PathVariable Long id)
    {
        return doctorRepository.findById(id);
    }
    @PutMapping("/change")
    public ResponseEntity<Doctor> changingParam(@PathVariable Long id,
                                                @RequestBody Doctor currentdoctor)
            throws ResourceNotFoundException

    {
      Doctor doctor=doctorRepository.findById(id)
              .orElseThrow(() ->
                      new ResourceNotFoundException(currentdoctor.getNameDoctor()+"This doctor does not exist"));
      doctor.setNameDoctor(currentdoctor.getNameDoctor());
      doctor.setOccupation(currentdoctor.getOccupation());
      final Doctor newStaff=doctorRepository.save(doctor);
      return ResponseEntity.ok(newStaff);

    }
    @GetMapping("/finding")
    public int counting(@RequestParam(name = "nameDoctor") String nameDoctor)
    {
      Optional<Doctor> doctor= Optional.ofNullable(doctorRepository.findByNameDoctor(nameDoctor));

       if (doctor.isPresent())
        {
            counting++;

        }
        return counting;
    }

}
