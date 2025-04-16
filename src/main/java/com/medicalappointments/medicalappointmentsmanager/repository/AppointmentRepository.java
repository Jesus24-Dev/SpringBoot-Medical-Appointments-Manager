
package com.medicalappointments.medicalappointmentsmanager.repository;

import com.medicalappointments.medicalappointmentsmanager.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
    
}
