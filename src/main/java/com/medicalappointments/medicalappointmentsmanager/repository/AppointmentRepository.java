
package com.medicalappointments.medicalappointmentsmanager.repository;

import com.medicalappointments.medicalappointmentsmanager.models.Appointment;
import com.medicalappointments.medicalappointmentsmanager.models.Doctor;
import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
    boolean existsByDoctorAndAppointmentDateAndAppointmentTime(Doctor doctor, LocalDate appointmentDate, LocalTime appointmentTime);
}
