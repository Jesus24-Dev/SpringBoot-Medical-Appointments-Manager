
package com.medicalappointments.medicalappointmentsmanager.dtos.response;

import com.medicalappointments.medicalappointmentsmanager.enums.DoctorSpecialty;
import com.medicalappointments.medicalappointmentsmanager.enums.Shift;
import com.medicalappointments.medicalappointmentsmanager.models.Doctor;
import java.util.UUID;

public class DoctorMinResponse {
    private final UUID id;
    private final String name;
    private final String lastname;
    private final Shift shiftType;
    private final DoctorSpecialty specialty;
    
    public DoctorMinResponse(Doctor doctor){
        this.id = doctor.getId();
        this.name = doctor.getName();
        this.lastname = doctor.getLastname();
        this.shiftType = doctor.getShiftType();
        this.specialty = doctor.getSpecialty();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public Shift getShiftType() {
        return shiftType;
    }     

    public DoctorSpecialty getSpecialty() {
        return specialty;
    }
    
    
}
