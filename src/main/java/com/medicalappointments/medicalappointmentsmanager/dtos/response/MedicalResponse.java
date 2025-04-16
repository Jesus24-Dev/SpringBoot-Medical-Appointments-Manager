
package com.medicalappointments.medicalappointmentsmanager.dtos.response;

import com.medicalappointments.medicalappointmentsmanager.enums.MedicalSpecialty;
import com.medicalappointments.medicalappointmentsmanager.enums.Shift;
import com.medicalappointments.medicalappointmentsmanager.models.Medical;
import java.util.List;
import java.util.UUID;

public class MedicalResponse {
    private final UUID id;
    private final String name;
    private final String lastname;
    private final MedicalSpecialty specialty;
    private final Shift shiftType;
    private final List<AppointmentResponse> medicalAppointments;  

    public MedicalResponse(Medical medical) {
        this.id = medical.getId();
        this.name = medical.getName();
        this.lastname = medical.getLastname();
        this.specialty = medical.getSpecialty();
        this.shiftType = medical.getShiftType();
        this.medicalAppointments = medical.getMedicalAppointments().stream()
                .map(AppointmentResponse::new)
                .toList();;
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

    public Shift getShiftType() {
        return shiftType;
    }

    public List<AppointmentResponse> getMedicalAppointments() {
        return medicalAppointments;
    }
          
}
