package com.medicine.demo.controller;
import com.medicine.demo.dao.dto.DoctorDTO;

import com.medicine.demo.entity.Doctor;
import com.medicine.demo.factories.DoctorDTOtoDoctor;
import com.medicine.demo.factories.DoctortoDoctorDTO;
import com.medicine.demo.service.DoctorDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api")
public class DoctorController
{
   private DoctortoDoctorDTO doctortoDoctorDTO;
   private DoctorDTOtoDoctor doctorDTOtoDoctor;
   private DoctorDAOImpl doctorDAOImpl;

   @Autowired
    public DoctorController(DoctortoDoctorDTO doctortoDoctorDTO,
                            DoctorDTOtoDoctor doctorDTOtoDoctor,
                            DoctorDAOImpl doctorDAOImpl) {
        this.doctortoDoctorDTO = doctortoDoctorDTO;
        this.doctorDTOtoDoctor = doctorDTOtoDoctor;
        this.doctorDAOImpl = doctorDAOImpl;
    }
    @GetMapping("/all")
    public ResponseEntity<List<DoctorDTO>> gettingAll()
    {
     List<DoctorDTO> doctorDTOS= new ArrayList<>();
    for (Doctor doctor:doctorDAOImpl.getAllDoctors())
    {
        doctorDTOS.add(doctortoDoctorDTO.convert(doctor));
    }
    return new ResponseEntity<>(doctorDTOS, HttpStatus.OK);
    }
    @GetMapping("/all/{id}")
    public ResponseEntity<DoctorDTO> gettingOne(@PathVariable UUID id)
    {
      Doctor doctor=doctorDAOImpl.findById(id);
      if (doctor==null)
      {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(HttpStatus.FOUND);
    }
    @PostMapping("/add")
    public ResponseEntity<DoctorDTO> saving(@RequestBody DoctorDTO doctorDTO)
    {
        doctorDAOImpl.save(doctorDTOtoDoctor.convert(doctorDTO));
       return  new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/doctor/{id}")
    public ResponseEntity<DoctorDTO> changing(@PathVariable UUID id,
                                              @RequestBody DoctorDTO doctorDTO)
    {
       doctorDTO.setId(id);
       doctorDAOImpl.save(doctorDTOtoDoctor.convert(doctorDTO));
       return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DoctorDTO> deleting(@PathVariable UUID id)
    {
     try {
    doctorDAOImpl.deleteById(id);
     return new ResponseEntity<>(HttpStatus.OK);
     }
     catch (Exception ex)
     {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
    }
////    @PutMapping
}