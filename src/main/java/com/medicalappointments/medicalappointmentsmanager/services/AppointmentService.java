
package com.medicalappointments.medicalappointmentsmanager.services;

import com.medicalappointments.medicalappointmentsmanager.models.Appointment;
import com.medicalappointments.medicalappointmentsmanager.models.Doctor;
import com.medicalappointments.medicalappointmentsmanager.repository.AppointmentRepository;
import com.medicalappointments.medicalappointmentsmanager.repository.PatientRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    
    @Autowired
    private AppointmentRepository appointmentRepository;
    
    public boolean existsByDoctorAndDateAndHour(Doctor doctor, LocalDate date, LocalTime hour) {
        return appointmentRepository.existsByDoctorAndAppointmentDateAndAppointmentTime(doctor, date, hour);
    }
    
    public Appointment getAppointmentById(Long id){
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not founded"));
        return appointment;
    }
    
    public Appointment createAppointment(Appointment request){
        Appointment appointment = new Appointment();
        
        appointment.setPatient(request.getPatient());
        appointment.setDoctor(request.getDoctor());
        appointment.setAppointmentDate(request.getAppointmentDate());
        appointment.setAppointmentTime(request.getAppointmentTime());
        
        Appointment appointmentSaved = appointmentRepository.save(appointment);
        return appointmentSaved;
    }

    public boolean cancelAppointmentIfFuture(Long id, String email) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);

        if (optionalAppointment.isPresent()) {
            Appointment appt = optionalAppointment.get();
            if (!appt.getPatient().getEmail().equals(email)) return false;

            if (appt.getAppointmentDate().isAfter(LocalDate.now())) {
                appointmentRepository.delete(appt);
                return true;
            }
        }
        return false;
    }
    
    public void deleteAppointment(Long id){
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not founded"));
        appointmentRepository.delete(appointment);
    }
}
