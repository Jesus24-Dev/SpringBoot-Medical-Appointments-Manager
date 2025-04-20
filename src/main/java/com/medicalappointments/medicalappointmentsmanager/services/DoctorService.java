
package com.medicalappointments.medicalappointmentsmanager.services;

import com.medicalappointments.medicalappointmentsmanager.dtos.response.DoctorResponse;
import com.medicalappointments.medicalappointmentsmanager.enums.DoctorSpecialty;
import com.medicalappointments.medicalappointmentsmanager.models.Doctor;
import com.medicalappointments.medicalappointmentsmanager.repository.DoctorRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    public DoctorRepository doctorRepository;
    
    public List<DoctorResponse> getAllDoctors(){
        List<Doctor> doctors = doctorRepository.findAll();
        
        return doctors.stream().map(DoctorResponse::new).toList();
    }
    
    public List<DoctorResponse> searchBySpecialty(String specialtyText) {
        try {
            DoctorSpecialty specialty = DoctorSpecialty.valueOf(specialtyText.toUpperCase());
            List<Doctor> doctors = doctorRepository.findBySpecialty(specialty);
            return doctors.stream().map(DoctorResponse::new).toList();
        } catch (IllegalArgumentException e) {
            return List.of();
        }
    }
    
    public Doctor getDoctorById(UUID id){
        Doctor doctor = doctorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Doctor not founded with ID: " + id));
        return doctor;
    }
}
