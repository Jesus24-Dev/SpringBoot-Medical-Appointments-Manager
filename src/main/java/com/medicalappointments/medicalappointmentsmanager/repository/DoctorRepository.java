
package com.medicalappointments.medicalappointmentsmanager.repository;

import com.medicalappointments.medicalappointmentsmanager.enums.DoctorSpecialty;
import com.medicalappointments.medicalappointmentsmanager.models.Doctor;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, UUID>{
    List<Doctor> findBySpecialty(DoctorSpecialty specialty);

}
