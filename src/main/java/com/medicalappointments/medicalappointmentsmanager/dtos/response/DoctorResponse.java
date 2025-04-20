
package com.medicalappointments.medicalappointmentsmanager.dtos.response;

import com.medicalappointments.medicalappointmentsmanager.enums.DoctorSpecialty;
import com.medicalappointments.medicalappointmentsmanager.enums.Shift;
import com.medicalappointments.medicalappointmentsmanager.models.Doctor;
import java.util.List;
import java.util.UUID;

public class DoctorResponse {
    private final UUID id;
    private final String name;
    private final String lastname;
    private final DoctorSpecialty specialty;
    private final Shift shiftType;
    private final List<AppointmentResponse> doctorAppointments;  

    public DoctorResponse(Doctor doctor) {
        this.id = doctor.getId();
        this.name = doctor.getName();
        this.lastname = doctor.getLastname();
        this.specialty = doctor.getSpecialty();
        this.shiftType = doctor.getShiftType();
        this.doctorAppointments = doctor.getDoctorAppointments().stream()
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

    public DoctorSpecialty getSpecialty() {
        return specialty;
    }

    public Shift getShiftType() {
        return shiftType;
    }

    public List<AppointmentResponse> getDoctorAppointments() {
        return doctorAppointments;
    }
          
}
