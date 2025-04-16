
package com.medicalappointments.medicalappointmentsmanager.dtos.request;

import com.medicalappointments.medicalappointmentsmanager.enums.MedicalSpecialty;
import com.medicalappointments.medicalappointmentsmanager.enums.Shift;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class MedicalRequest {
    
    @NotBlank(message = "Name is required")
    @Size(min = 3, message = "Insert a valid name")
    private String name;
    
    @NotBlank(message = "Lastname is required")
    @Size(min = 3, message = "Insert a valid lastname")
    private String lastname;
    
    @NotEmpty(message = "Medical Specialty is required")
    private MedicalSpecialty specialty;
    
    @NotEmpty(message = "Medical Shift type is required")
    private Shift shiftType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public MedicalSpecialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(MedicalSpecialty specialty) {
        this.specialty = specialty;
    }

    public Shift getShiftType() {
        return shiftType;
    }

    public void setShiftType(Shift shiftType) {
        this.shiftType = shiftType;
    }
    
}
