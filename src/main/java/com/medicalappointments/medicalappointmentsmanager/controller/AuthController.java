
package com.medicalappointments.medicalappointmentsmanager.controller;

import com.medicalappointments.medicalappointmentsmanager.dtos.request.PatientRequest;
import com.medicalappointments.medicalappointmentsmanager.services.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    
    @Autowired
    private PatientService patientService;
    
    @GetMapping({"/", "/login"})
    public String loginPage(Model model){
        model.addAttribute("patient", new PatientRequest());
        return "login";
    }
       
    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("patient", new PatientRequest());
        return "register";
    }
    
    @PostMapping("/register")
    public String processRegisterForm(
            @Valid @ModelAttribute("patient") PatientRequest patient,
            BindingResult result,
            Model model){
        if(result.hasErrors()){
            return "register";
        }
              
        patientService.savePatient(patient);
        model.addAttribute("patient", patient);
        
        return "login";
    }
}
