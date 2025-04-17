
package com.medicalappointments.medicalappointmentsmanager.repository;

import com.medicalappointments.medicalappointmentsmanager.models.Doctor;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, UUID>{
    Optional<Doctor> findBySpecialty(String specialty);
}
