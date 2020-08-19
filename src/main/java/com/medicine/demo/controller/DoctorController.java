package com.medicine.demo.controller;


import com.medicine.demo.entity.Doctor;
import com.medicine.demo.payload.ApiResponse;
import com.medicine.demo.repository.DoctorRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/api")
public class DoctorController
{
 private final DoctorRepository doctorRepository;
    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("/all")
    public List<Doctor> retrieveAllDoctors()
    {
      return  doctorRepository.findAll();
    }

    @GetMapping("/all/{id}")
    public EntityModel<Doctor> retrieveStudent(@PathVariable UUID id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);

        if (!doctor.isPresent())
            throw new ResourceNotFoundException(id+"this kind of user does not exit-" + id);

        EntityModel<Doctor> resource = EntityModel.of(doctor.get());

        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllDoctors());

        resource.add(linkTo.withRel("get press to show all"));

        return resource;
    }

    @PostMapping("/send")
    public ApiResponse transmittingData(@RequestBody Doctor doctor)
    {
     doctorRepository.save(doctor);
     return new ApiResponse("New doctor has successfully added",true);
    }

    @PutMapping("/change/{id}")
    public ResponseEntity<Doctor> updating(@PathVariable UUID id,
                                         @Valid @RequestBody Doctor doctor)
            throws ResourceNotFoundException
    {
        Doctor doctor1=doctorRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException(id+"This kind of user not found"));
        doctor1.setOccupation(doctor.getOccupation());
        doctor1.setCounting(doctor.getCounting());
        final Doctor update=doctorRepository.save(doctor1);
        return ResponseEntity.ok(update);
    }

}
