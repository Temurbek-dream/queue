package com.medicine.demo.dao.dto;

import java.util.UUID;

public class DoctorDTO
{
  private UUID id;

  private String occupation;

  private  String description;

    public UUID getId()
    {
        return id;
    }

    public void setId(UUID id)
    {
        this.id = id;
    }

    public String getOccupation()
    {
        return occupation;
    }

    public void setOccupation(String occupation)
    {
        this.occupation = occupation;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DoctorDTO{" +
                "id=" + id +
                ", occupation='" + occupation + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
