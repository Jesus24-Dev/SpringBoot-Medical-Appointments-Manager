
package com.medicalappointments.medicalappointmentsmanager.services;

import com.medicalappointments.medicalappointmentsmanager.models.Patient;
import com.medicalappointments.medicalappointmentsmanager.repository.PatientRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PatientDetailsService implements UserDetailsService {

    private final PatientRepository patientRepository;

    public PatientDetailsService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Patient patient = patientRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Patient not found with email: " + email));
    
        return User.builder()
            .username(patient.getEmail())
            .password(patient.getPassword())
            .roles("PATIENT")
            .build();
    }
}

