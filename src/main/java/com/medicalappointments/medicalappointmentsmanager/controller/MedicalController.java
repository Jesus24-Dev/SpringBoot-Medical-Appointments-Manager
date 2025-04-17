
package com.medicalappointments.medicalappointmentsmanager.controller;

import com.medicalappointments.medicalappointmentsmanager.dtos.response.MedicalResponse;
import com.medicalappointments.medicalappointmentsmanager.services.MedicalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medical")
public class MedicalController {
    
    @Autowired
    private MedicalService medicalService;
    
    @GetMapping("/list")
    public String getMedicalList(Model model){
        List<MedicalResponse> medicals = medicalService.getAllMedicals();
        model.addAttribute("medicals", medicals);
        return "medicalList";
    }
}
