package com.medicine.demo.dao;


import com.medicine.demo.entity.Doctor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fake")
public class DoctorDataAccess implements DoctorDao
{
    private static List<Doctor> doc=new ArrayList<>();

    @Override
    public int insertPerson(Doctor doctor) {
        doc.add(new Doctor(doctor.getOccupation(),doctor.getCounting()));
        return 0;
//        return 1;
    }

    @Override
    public List<Doctor> selectAllDoctors() {
        return doc;
    }

    @Override
    public Optional<Doctor> selectDoctorById(UUID id) {
        return doc.stream()
                .filter(doctor -> doctor.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteDoctorById(UUID id) {
     Optional<Doctor> doctormaybe=selectDoctorById(id);
       if (doctormaybe.isPresent())
       {
           return 0;
       }
        doc.remove(doctormaybe.get());
        return 1;
    }

    @Override
    public int updateDoctorById(UUID id,Doctor doctor)
    {
        return selectDoctorById(id)
                .map(doctor1 ->
                {
                    int indexOfDoctorToDelete=doc.indexOf(doctor1);
                    if (indexOfDoctorToDelete>=0)
                    {
               doc.set(indexOfDoctorToDelete,
               new Doctor(doctor.getOccupation(),doctor.getCounting()));
               return 1;
                    }
                    return 0;
                }
                        ).orElse(0);
    }
}
