
package com.medicalappointments.medicalappointmentsmanager.repository;

import com.medicalappointments.medicalappointmentsmanager.models.Patient;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, UUID>{
    
}
