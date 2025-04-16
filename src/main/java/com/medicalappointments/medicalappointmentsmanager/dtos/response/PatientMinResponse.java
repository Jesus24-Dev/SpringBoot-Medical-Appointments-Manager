
package com.medicalappointments.medicalappointmentsmanager.dtos.response;

import com.medicalappointments.medicalappointmentsmanager.models.Patient;
import java.util.UUID;

public class PatientMinResponse {
    private final UUID id;
    private final String name;
    private final String lastname;
    
    public PatientMinResponse(Patient patient) {
        this.id = patient.getId();
        this.name = patient.getName();
        this.lastname = patient.getLastname();
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
    
    
}
