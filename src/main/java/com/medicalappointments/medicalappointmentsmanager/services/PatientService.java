
package com.medicalappointments.medicalappointmentsmanager.services;

import com.medicalappointments.medicalappointmentsmanager.dtos.request.PatientRequest;
import com.medicalappointments.medicalappointmentsmanager.dtos.response.PatientResponse;
import com.medicalappointments.medicalappointmentsmanager.models.Patient;
import com.medicalappointments.medicalappointmentsmanager.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    
    @Autowired
    private PatientRepository patientRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    public PatientResponse savePatient(PatientRequest request){
        Patient patient = new Patient();
        patient.setName(request.getName());
        patient.setLastname(request.getLastname());
        patient.setEmail(request.getEmail());
        patient.setGender(request.getGender());
        
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        patient.setPassword(encodedPassword);
        
        Patient savedPatient = patientRepository.save(patient);
        return new PatientResponse(savedPatient);
    }
    
    public Patient getPatientByEmail(String email){
        Patient patient = patientRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Patient not founded with email: " + email));
        
        return patient;
    }
}
