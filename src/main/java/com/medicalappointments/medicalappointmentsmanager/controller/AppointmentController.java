
package com.medicalappointments.medicalappointmentsmanager.controller;

import com.medicalappointments.medicalappointmentsmanager.dtos.request.AppointmentRequest;
import com.medicalappointments.medicalappointmentsmanager.dtos.response.DoctorResponse;
import com.medicalappointments.medicalappointmentsmanager.models.Appointment;
import com.medicalappointments.medicalappointmentsmanager.models.Doctor;
import com.medicalappointments.medicalappointmentsmanager.models.Patient;
import com.medicalappointments.medicalappointmentsmanager.services.AppointmentService;
import com.medicalappointments.medicalappointmentsmanager.services.DoctorService;
import com.medicalappointments.medicalappointmentsmanager.services.PatientService;
import com.medicalappointments.medicalappointmentsmanager.utils.AppointmentUtils;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {
    
    @Autowired
    private AppointmentService appointmentService;
    
    @Autowired
    private DoctorService doctorService;
    
    @Autowired
    private PatientService patientService;
    
    @GetMapping("/schedule")
    public String scheduleAppointment(@RequestParam("doctorId") UUID doctorId, Model model){
        Doctor doctor = doctorService.getDoctorById(doctorId);
        List<LocalTime> availableHours = AppointmentUtils.getAvailableHoursByShift(doctor.getShiftType());
        model.addAttribute("doctor", new DoctorResponse(doctor));
        model.addAttribute("availableHours", availableHours);
        model.addAttribute("appointmentRequest", new AppointmentRequest());
        return "scheduleAppointment";
    }
    
    @PostMapping("/confirm")
    public String confirmAppointment(
            @ModelAttribute AppointmentRequest appointmentRequest,
            Principal principal,
            RedirectAttributes redirectAttributes
    ) {
        
        Doctor doctor = doctorService.getDoctorById(appointmentRequest.getDoctor().getId());
        Patient patient = patientService.getPatientByEmail(principal.getName());
        boolean exists = appointmentService.existsByDoctorAndDateAndHour(
                doctor, appointmentRequest.getAppointmentDate(), appointmentRequest.getAppointmentTime()
        );

        if (exists) {
            redirectAttributes.addFlashAttribute("error", "The doctor already has an appointment at that time.");
            return "redirect:/appointment/schedule?doctorId=" + doctor.getId();
        }
        
        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setAppointmentDate(appointmentRequest.getAppointmentDate());
        appointment.setAppointmentTime(appointmentRequest.getAppointmentTime());
        
        System.out.println("Horarios");
        System.out.println(appointmentRequest.getAppointmentDate());
        System.out.println(appointmentRequest.getAppointmentTime());
        
        appointmentService.createAppointment(appointment);
       
        redirectAttributes.addFlashAttribute("success", "Appointment confirmed successfully!");
        return "redirect:/patient/myAppointments";
    }
    
    @PostMapping("/cancel/{id}")
    public String cancelAppointment(@PathVariable Long id, Principal principal, RedirectAttributes redirectAttributes) {
        Appointment appointment = appointmentService.getAppointmentById(id);

        Patient patient = patientService.getPatientByEmail(principal.getName());

        if (!appointment.getPatient().getId().equals(patient.getId())) {
            redirectAttributes.addFlashAttribute("error", "You don't have permission to cancel this appointment.");
            return "redirect:/patient/myAppointments";
        }

        if (!appointment.getAppointmentDate().isAfter(LocalDate.now())) {
            redirectAttributes.addFlashAttribute("error", "You can't cancel a past appointment.");
            return "redirect:/patient/myAppointments";
        }

        appointmentService.deleteAppointment(appointment.getId());

        redirectAttributes.addFlashAttribute("success", "Appointment successfully cancelled.");
        return "redirect:/patient/myAppointments";
    }


}
