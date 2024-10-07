package org.fai.study.btvn.controller;

import org.fai.study.btvn.entity.Appointment;
import org.fai.study.btvn.entity.Doctor;
import org.fai.study.btvn.entity.Patient;
import org.fai.study.btvn.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private IAppointmentService appointmentService;

    @Autowired
    private IPatientService patientService;

    @Autowired
    private IDoctorService doctorService;

    @GetMapping()
    public String getAppointments(Model model) {
        List<Appointment> appointments = appointmentService.getAppointments();
        model.addAttribute("appointments", appointments);
        return "appointment/appointment";
    }
    @GetMapping("/add")
    public String createAppointmentForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("patients", patientService.getPatient());
        model.addAttribute("doctors", doctorService.getDoctor());
        return "appointment/create";
    }

    @PostMapping("/add")
    public String addAppointment(@ModelAttribute Appointment appointment, Model model) {
        try {
            appointmentService.addAppointment(appointment);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "appointment/create";
        }
        return "redirect:/appointments";
    }

    @GetMapping("/update/{id}")
    public String editAppointmentForm(@PathVariable int id, Model model) {
        Appointment appointment = appointmentService.getAppointmentbyId(id);
        model.addAttribute("appointment", appointment);
        model.addAttribute("patients", patientService.getPatient());
        model.addAttribute("doctors", doctorService.getDoctor());
        return "appointment/edit";
    }

    @PostMapping("/update/{id}")
    public String updateAppointment(@PathVariable int id, @ModelAttribute Appointment appointment, Model model) {
        try {
            appointmentService.updateAppointment(id, appointment);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "appointment/edit";
        }
        return "redirect:/appointments";
    }

    @PostMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable int id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/appointments";
    }
}
