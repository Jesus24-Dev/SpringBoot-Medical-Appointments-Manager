
package com.medicalappointments.medicalappointmentsmanager.dtos.response;

import com.medicalappointments.medicalappointmentsmanager.enums.MedicalSpecialty;
import com.medicalappointments.medicalappointmentsmanager.models.Medical;
import java.util.UUID;

public class MedicalMinResponse {
    private final UUID id;
    private final String name;
    private final String lastname;
    private final MedicalSpecialty specialty;
    
    public MedicalMinResponse(Medical medical){
        this.id = medical.getId();
        this.name = medical.getName();
        this.lastname = medical.getLastname();
        this.specialty = medical.getSpecialty();
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

    public MedicalSpecialty getSpecialty() {
        return specialty;
    }
    
    
}
