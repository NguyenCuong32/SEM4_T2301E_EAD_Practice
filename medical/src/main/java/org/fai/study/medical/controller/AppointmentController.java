package org.fai.study.medical.controller;

import org.fai.study.medical.entity.Appointment;
import org.fai.study.medical.service.IAppointmentService;
import org.fai.study.medical.service.IDoctorService;
import org.fai.study.medical.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {
    final
    IAppointmentService appointmentService;
    final
    IDoctorService doctorService;
    final
    IPatientService patientService;

    public AppointmentController(IAppointmentService appointmentService, IDoctorService doctorService, IPatientService patientService) {
        this.appointmentService = appointmentService;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    @GetMapping("/appointmentList")
    public String appointmentList(Model model) {
        model.addAttribute("doctors",doctorService.getDoctors());
        model.addAttribute("patients",patientService.getAllPatients());
        model.addAttribute("appointments", appointmentService.getAppointments());
        return "appointment/index";
    }

    @PostMapping("/addAppoint")
    public String addAppointment(@ModelAttribute("appointment") Appointment appointment,
                                 @RequestParam int patientId,
                                 @RequestParam int doctorId) {
        try {
            appointmentService.addAppointment(appointment, patientId, doctorId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/appointments/appointmentList";
    }

    @PostMapping("/update")
    public String updateAppointment(@RequestParam("appointmentId") int appointmentId,
                                    @ModelAttribute("appointment") Appointment updatedAppointment,
                                    @RequestParam("patientId") int patientId,
                                    @RequestParam("doctorId") int doctorId) {
        appointmentService.updateAppointment(appointmentId, updatedAppointment, patientId, doctorId);
        return "redirect:/appointments/appointmentList";
    }

    @GetMapping("/delete/{appointmentId}")
    public String deleteAppointment(@PathVariable("appointmentId") int appointmentId) {
        appointmentService.deleteAppointment(appointmentId);
        return "redirect:/appointments/appointmentList";
    }
}
