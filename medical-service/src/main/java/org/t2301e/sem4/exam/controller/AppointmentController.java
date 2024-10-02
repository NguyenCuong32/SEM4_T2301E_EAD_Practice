package org.t2301e.sem4.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.t2301e.sem4.exam.entity.Appointment;
import org.t2301e.sem4.exam.service.IAppointmentService;
import org.t2301e.sem4.exam.service.IDoctorService;
import org.t2301e.sem4.exam.service.IPatientService;

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

    @GetMapping
    public String listAppointments(Model model) {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        model.addAttribute("appointments", appointments);
        return "appointment/list";
    }

    @GetMapping("/create")
    public String createAppointmentForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "appointment/create";
    }

    @PostMapping
    public String saveAppointment(@ModelAttribute Appointment appointment, Model model) {
        try {
            appointmentService.saveAppointment(appointment);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "appointment/create";
        }
        return "redirect:/appointments";
    }

    @GetMapping("/edit/{id}")
    public String editAppointmentForm(@PathVariable int id, Model model) {
        Appointment appointment = appointmentService.getAppointmentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found."));
        model.addAttribute("appointment", appointment);
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "appointment/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateAppointment(@PathVariable int id, @ModelAttribute Appointment appointment, Model model) {
        try {
            appointmentService.updateAppointment(id, appointment);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "appointment/edit";
        }
        return "redirect:/appointments";
    }

    @GetMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable int id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/appointments";
    }
}

