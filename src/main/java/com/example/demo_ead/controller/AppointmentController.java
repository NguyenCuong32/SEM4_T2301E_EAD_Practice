package com.example.demo_ead.controller;

import com.example.demo_ead.entity.Appointment;
import com.example.demo_ead.entity.Doctor;
import com.example.demo_ead.entity.Patient;
import com.example.demo_ead.service.AppointmentService;
import com.example.demo_ead.service.DoctorService;
import com.example.demo_ead.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @GetMapping
    public String listAppointments(Model model) {
        model.addAttribute("appointments", appointmentService.getAllAppointments());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("appointment", new Appointment()); // For creating new appointment
        return "appointment";
    }

    @GetMapping("/edit/{id}")
    public String showEditAppointmentForm(@PathVariable("id") int id, Model model) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        if (appointment != null) {
            model.addAttribute("appointment", appointment);
            model.addAttribute("doctors", doctorService.getAllDoctors());
            model.addAttribute("patients", patientService.getAllPatients());
            return "appointment";
        } else {
            return "redirect:/appointments";
        }
    }

    @PostMapping
    public String saveOrUpdateAppointment(@ModelAttribute("appointment") Appointment appointment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("doctors", doctorService.getAllDoctors());
            model.addAttribute("patients", patientService.getAllPatients());
            return "appointment";
        }
        appointmentService.saveAppointment(appointment);
        return "redirect:/appointments";
    }



    @GetMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable("id") int id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/appointments";
    }
}
