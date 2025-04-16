
package com.medicalappointments.medicalappointmentsmanager.dtos.response;

import com.medicalappointments.medicalappointmentsmanager.models.Appointment;
import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentResponse {

    private final Long id;
    
    private final PatientMinResponse patient;
    private final MedicalMinResponse medical;
    
    private final LocalDate appointmentDate;
    private final LocalTime appointmentTime;

    public AppointmentResponse(Appointment appointment) {
        this.id = appointment.getId();
        this.patient = new PatientMinResponse(appointment.getPatient());
        this.medical = new MedicalMinResponse(appointment.getMedical());
        this.appointmentDate = appointment.getAppointmentDate();
        this.appointmentTime = appointment.getAppointmentTime();
    }

    public Long getId() {
        return id;
    }

    public PatientMinResponse getPatient() {
        return patient;
    }

    public MedicalMinResponse getMedical() {
        return medical;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }
    
    
}
