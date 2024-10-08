package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Appointment;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.service.AppointmentService;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PatientService;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private DoctorService doctorService; // Để hiển thị danh sách bác sĩ
    @Autowired
    private PatientService patientService; // Để hiển thị danh sách bệnh nhân

    // Hiển thị danh sách cuộc hẹn
    @GetMapping
    public String listAppointments(Model model) {
        model.addAttribute("appointments", appointmentService.getAllAppointments());
        return "appointments/index";
    }

    // Hiển thị form thêm mới cuộc hẹn
    @GetMapping("/new")
    public String showNewAppointmentForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        model.addAttribute("patients", patientService.getAllPatients());
        return "appointments/new";
    }

    // Xử lý thêm mới cuộc hẹn
    @PostMapping
    public String saveAppointment(@ModelAttribute("appointment") Appointment appointment) {
        Doctor doctor = doctorService.getDoctorById(appointment.getDoctor().getDoctorId());
        Patient patient = patientService.getPatientById(appointment.getPatient().getPatientId());

        // Gán lại đối tượng Doctor và Patient vào Appointment
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointmentService.saveAppointment(appointment);
        return "redirect:/appointments";
    }

    // Hiển thị form chỉnh sửa cuộc hẹn
    @GetMapping("/edit/{id}")
    public String showEditAppointmentForm(@PathVariable int id, Model model) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        model.addAttribute("appointment", appointment);
        model.addAttribute("doctors", doctorService.getAllDoctors());
        model.addAttribute("patients", patientService.getAllPatients());
        return "appointments/edit";
    }

    // Xử lý cập nhật cuộc hẹn
    @PostMapping("/update/{id}")
    public String updateAppointment(@PathVariable int id, @ModelAttribute("appointment") Appointment appointment) {
        appointment.setAppointmentId(id);
        appointmentService.saveAppointment(appointment);
        return "redirect:/appointments";
    }

    // Xử lý xoá cuộc hẹn
    @GetMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable int id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/appointments";
    }

    // Xử lý chuyển đổi datetime từ String
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
