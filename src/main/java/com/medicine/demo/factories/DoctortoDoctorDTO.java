package com.medicine.demo.factories;

import com.medicine.demo.dao.dto.DoctorDTO;
import com.medicine.demo.entity.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctortoDoctorDTO
{
  public DoctorDTO convert(Doctor doctor)
  {
    DoctorDTO doctorDTO= new DoctorDTO();
    doctorDTO.setOccupation(doctor.getOccupation());
    doctorDTO.setDescription(doctor.getDescription());
    return doctorDTO;
  }
}
