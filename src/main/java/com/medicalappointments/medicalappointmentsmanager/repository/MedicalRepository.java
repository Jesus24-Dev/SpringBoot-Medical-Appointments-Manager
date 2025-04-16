
package com.medicalappointments.medicalappointmentsmanager.repository;

import com.medicalappointments.medicalappointmentsmanager.models.Medical;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRepository extends JpaRepository<Medical, UUID>{
    Optional<Medical> findBySpecialty(String specialty);
}
