
package com.medicalappointments.medicalappointmentsmanager.controller;

import com.medicalappointments.medicalappointmentsmanager.dtos.request.PatientRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("patient", new PatientRequest());
        return "register";
    }
    
    @PostMapping("/register")
    public String processRegisterForm(
            @Valid @ModelAttribute("patient") PatientRequest patient,
            BindingResult result){
        if(result.hasErrors()){
            return "register";
        }
        
        return "relax";
    }
}
