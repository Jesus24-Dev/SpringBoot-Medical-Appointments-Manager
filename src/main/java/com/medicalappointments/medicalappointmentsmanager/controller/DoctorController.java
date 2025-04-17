
package com.medicalappointments.medicalappointmentsmanager.controller;

import com.medicalappointments.medicalappointmentsmanager.dtos.response.DoctorResponse;
import com.medicalappointments.medicalappointmentsmanager.services.DoctorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    
    @Autowired
    private DoctorService doctorService;
    
    @GetMapping("/list")
    public String getDoctorList(Model model){
        List<DoctorResponse> doctors = doctorService.getAllDoctors();
        model.addAttribute("doctors", doctors);
        return "doctorList";
    }
    
    @GetMapping("/search")
    public String searchDoctorsBySpecialty(@RequestParam("specialty") String specialty, Model model) {
        List<DoctorResponse> doctors = doctorService.searchBySpecialty(specialty);
        model.addAttribute("doctors", doctors);
        return "doctorList";
    }
}
