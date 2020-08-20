package com.medicine.demo.controller;

import com.medicine.demo.payload.ApiResponse;
import com.medicine.demo.repository.DoctorRepository;
import com.medicine.demo.service.CountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CounterController
{
     private final DoctorRepository doctorRepository;
     private final CountService countService;

    public CounterController(DoctorRepository doctorRepository, CountService countService)
    {
        this.doctorRepository = doctorRepository;
        this.countService = countService;
    }

    @GetMapping("/counter/{id}")
    public ApiResponse count(@PathVariable UUID id)
    {
        countService.countt(id);
      return new ApiResponse("Added",true);
    }
}
