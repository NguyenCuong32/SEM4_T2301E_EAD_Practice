package org.t2301e.sem4.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.t2301e.sem4.exam.entity.Doctor;
import org.t2301e.sem4.exam.service.IDoctorService;

import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private IDoctorService doctorService;

    @GetMapping
    public String listDoctors(Model model) {
        List<Doctor> doctors = doctorService.getAllDoctors();
        model.addAttribute("doctors", doctors);
        return "doctor/list";
    }

    @GetMapping("/create")
    public String createDoctorForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctor/create";
    }

    @PostMapping
    public String saveDoctor(@ModelAttribute Doctor doctor, Model model) {
        try {
            doctorService.saveDoctor(doctor);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "doctor/create";
        }
        return "redirect:/doctors";
    }

    @GetMapping("/edit/{id}")
    public String editDoctorForm(@PathVariable int id, Model model) {
        Doctor doctor = doctorService.getDoctorById(id);
        model.addAttribute("doctor", doctor);
        return "doctor/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateDoctor( @PathVariable("id") int id,
                                @ModelAttribute Doctor doctor,
                                Model model
    ) {
        try {
            doctorService.updateDoctor(id, doctor);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("doctor", doctor);
            return "doctor/edit";
        }
        return "redirect:/doctors";
    }

    @GetMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable int id) {
        doctorService.deleteDoctor(id);
        return "redirect:/doctors";
    }
}
