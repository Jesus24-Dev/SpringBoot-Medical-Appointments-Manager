
package com.medicalappointments.medicalappointmentsmanager.models;

import com.medicalappointments.medicalappointmentsmanager.enums.MedicalSpecialty;
import com.medicalappointments.medicalappointmentsmanager.enums.Shift;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "medical")
public class Medical {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private String name;
    private String lastname;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "specialty")
    private MedicalSpecialty specialty;
    
    @Enumerated(EnumType.STRING)  
    @Column(name ="shift")
    private Shift shiftType;

    public Medical() {
    }

    public Medical(UUID id, String name, String lastname, MedicalSpecialty specialty, Shift shiftType) {
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
