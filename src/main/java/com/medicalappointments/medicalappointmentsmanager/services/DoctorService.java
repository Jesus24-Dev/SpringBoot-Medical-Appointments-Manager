
package com.medicalappointments.medicalappointmentsmanager.services;

import com.medicalappointments.medicalappointmentsmanager.dtos.response.DoctorResponse;
import com.medicalappointments.medicalappointmentsmanager.models.Doctor;
import com.medicalappointments.medicalappointmentsmanager.repository.DoctorRepository;
import java.util.List;
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
}
