
package com.medicalappointments.medicalappointmentsmanager.services;

import com.medicalappointments.medicalappointmentsmanager.dtos.response.MedicalResponse;
import com.medicalappointments.medicalappointmentsmanager.models.Medical;
import com.medicalappointments.medicalappointmentsmanager.repository.MedicalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalService {
    @Autowired
    public MedicalRepository medicalRepository;
    
    public List<MedicalResponse> getAllMedicals(){
        List<Medical> medicals = medicalRepository.findAll();
        
        return medicals.stream().map(MedicalResponse::new).toList();
    }
}
