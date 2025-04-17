
package com.medicalappointments.medicalappointmentsmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patient") 
public class PatientController {

    @GetMapping("/myAppointments")
    public String myAppointments(Model model) {
        return "myAppointments";
    }
}
