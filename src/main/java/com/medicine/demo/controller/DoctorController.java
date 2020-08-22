package com.medicine.demo.controller;
import com.medicine.demo.entity.Doctor;
import com.medicine.demo.repository.DoctorRepository;
import com.medicine.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api")
public class DoctorController
{
    private final DoctorRepository doctorRepository;
    private final DoctorService doctorService;
    @Autowired
    public DoctorController(DoctorRepository doctorRepository,
                            DoctorService doctorService)
    {
        this.doctorRepository = doctorRepository;
        this.doctorService = doctorService;
    }
     @PostMapping
    public void addPerson(@Valid @NotNull @RequestBody Doctor doctor)
   {
      doctorService.AddDoctor(doctor);
   }

      @GetMapping
      public List<Doctor> getAllDoctors()
      {
       return doctorService.getAllDoctors();
      }

      @GetMapping(path = "{id}")
      public Doctor getDoctorById(UUID id)
      {
          return doctorService.getDoctorsById(id).orElse(null);
      }

      @DeleteMapping(path = "{id}")
      public void deleteById(@PathVariable("id") UUID id)
      {
         doctorService.deleteByIDD(id);
      }

      @PutMapping()

}
