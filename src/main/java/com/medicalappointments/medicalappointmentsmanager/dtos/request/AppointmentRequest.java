
package com.medicalappointments.medicalappointmentsmanager.dtos.request;

import com.medicalappointments.medicalappointmentsmanager.models.Doctor;
import com.medicalappointments.medicalappointmentsmanager.models.Patient;
import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentRequest {

    private Patient patient;
    
    private Doctor doctor;
    
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctorId(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
    
}
