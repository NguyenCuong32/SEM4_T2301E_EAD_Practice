package com.example.demo05.controller;

import com.example.demo05.entity.Doctor;
import com.example.demo05.service.DoctorService;
import com.example.demo05.entity.Doctor;
import com.example.demo05.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public String listDoctors(Model model) {
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "doctor/list";
    }

    @GetMapping("/new")
    public String newDoctorForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctor/form";
    }

    @PostMapping
    public String saveDoctor(@ModelAttribute Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/edit/{id}")
    public String editDoctorForm(@PathVariable Integer id, Model model) {
        model.addAttribute("doctor", doctorService.getDoctorById(id));
        return "doctor/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable Integer id) {
        doctorService.deleteDoctor(id);
        return "redirect:/doctors";
    }
}