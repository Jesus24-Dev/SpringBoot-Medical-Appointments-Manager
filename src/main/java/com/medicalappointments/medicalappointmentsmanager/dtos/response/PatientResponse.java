
package com.medicalappointments.medicalappointmentsmanager.dtos.response;

import com.medicalappointments.medicalappointmentsmanager.enums.Gender;
import com.medicalappointments.medicalappointmentsmanager.models.Patient;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class PatientResponse {
    
    private final UUID id;
    private final String name;
    private final String lastname;
    private final String email;
    private final Gender gender;    
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final List<AppointmentResponse> patientAppointments;  
    
    public PatientResponse(Patient patient) {
        this.id = patient.getId();
        this.name = patient.getName();
        this.lastname = patient.getLastname();
        this.email = patient.getEmail();
        this.gender = patient.getGender();
        this.createdAt = patient.getCreatedAt();
        this.updatedAt = patient.getUpdatedAt();
        this.patientAppointments = patient.getPatientAppointments().stream()
                .map(AppointmentResponse::new)
                .toList();
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

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public List<AppointmentResponse> getPatientAppointments() {
        return patientAppointments;
    }
    
    
}
