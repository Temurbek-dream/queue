package com.medicine.demo.factories;

import com.medicine.demo.dao.DoctorDAO;
import com.medicine.demo.dao.dto.DoctorDTO;
import com.medicine.demo.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoctorDTOtoDoctor
{
  private DoctorDAO doctorDAO;

    @Autowired
    public DoctorDTOtoDoctor(DoctorDAO doctorDAO)
    {
        this.doctorDAO = doctorDAO;
    }
  public Doctor convert(DoctorDTO doctorDTO)
  {
     Doctor doctor=doctorDTO.getId()!=null?doctorDAO.findById(doctorDTO.getId()):new Doctor();
     doctor.setOccupation(doctorDTO.getOccupation());
     doctor.setDescription(doctorDTO.getDescription());
     return doctor;
  }
}
