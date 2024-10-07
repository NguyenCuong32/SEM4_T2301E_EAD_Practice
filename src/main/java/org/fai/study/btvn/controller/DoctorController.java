package org.fai.study.btvn.controller;

import org.fai.study.btvn.entity.Doctor;
import org.fai.study.btvn.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping()
    public String getDoctors(Model model) {
        List<Doctor> doctors = doctorService.getDoctor();
        model.addAttribute("doctors", doctors);
        return "doctor/doctor";
    }

    @PostMapping("/add")
    public String addDoctor(@ModelAttribute Doctor doctor) {
        doctorService.addDoctor(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/update/{id}")
    public String updateDoctor(@PathVariable int id, Model model) {
        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor != null) {
            model.addAttribute("doctor", doctor);
        }
        return "doctor/edit";
    }

    @PostMapping("/update/{id}")
    public String updateDoctor(@PathVariable int id, @ModelAttribute Doctor doctor) {
        doctorService.updateDoctor(id, doctor);
        return "redirect:/doctors";
    }

    @PostMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable int id) {
        doctorService.deleteDoctor(id);
        return "redirect:/doctors";
    }
}