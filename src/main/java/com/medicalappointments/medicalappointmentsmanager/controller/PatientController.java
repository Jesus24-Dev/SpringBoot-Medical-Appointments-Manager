
package com.medicalappointments.medicalappointmentsmanager.controller;

import com.medicalappointments.medicalappointmentsmanager.models.Patient;
import com.medicalappointments.medicalappointmentsmanager.services.PatientService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patient") 
public class PatientController {
    
    @Autowired
    private PatientService patientService;

    @GetMapping("/myAppointments")
    public String myAppointments(Principal principal, Model model) {
        Patient patient = patientService.getPatientByEmail(principal.getName());
        model.addAttribute("appointments", patient.getPatientAppointments());
        return "myAppointments";
    }
}
