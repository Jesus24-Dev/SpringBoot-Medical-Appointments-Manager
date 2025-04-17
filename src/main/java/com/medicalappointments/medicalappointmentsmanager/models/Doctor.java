
package com.medicalappointments.medicalappointmentsmanager.models;

import com.medicalappointments.medicalappointmentsmanager.enums.DoctorSpecialty;
import com.medicalappointments.medicalappointmentsmanager.enums.Shift;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "doctor")
public class Doctor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private String name;
    private String lastname;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "specialty")
    private DoctorSpecialty specialty;
    
    @Enumerated(EnumType.STRING)  
    @Column(name ="shift")
    private Shift shiftType;
    
    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private List<Appointment> doctorAppointments = new ArrayList<>();

    public Doctor() {
    }

    public Doctor(UUID id, String name, String lastname, DoctorSpecialty specialty, Shift shiftType) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.specialty = specialty;
        this.shiftType = shiftType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public DoctorSpecialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(DoctorSpecialty specialty) {
        this.specialty = specialty;
    }

    public Shift getShiftType() {
        return shiftType;
    }

    public void setShiftType(Shift shiftType) {
        this.shiftType = shiftType;
    }

    public List<Appointment> getDoctorAppointments() {
        return doctorAppointments;
    }

    public void setDoctorAppointments(List<Appointment> doctorAppointments) {
        this.doctorAppointments = doctorAppointments;
    }  
    
}
