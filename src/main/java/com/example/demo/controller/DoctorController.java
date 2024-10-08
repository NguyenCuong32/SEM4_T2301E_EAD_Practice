package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Doctor;
import com.example.demo.service.DoctorService;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Hiển thị danh sách bác sĩ
    @GetMapping
    public String listDoctors(Model model) {
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "doctors/index"; // Trả về trang danh sách bác sĩ
    }

    // Hiển thị form thêm bác sĩ mới
    @GetMapping("/new")
    public String showNewDoctorForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctors/new"; // Trả về trang thêm bác sĩ mới
    }

    // Xử lý thêm mới bác sĩ
    @PostMapping
    public String saveDoctor(@ModelAttribute("doctor") Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors"; // Chuyển hướng về trang danh sách bác sĩ
    }

    // Hiển thị form chỉnh sửa bác sĩ
    @GetMapping("/edit/{id}")
    public String showEditDoctorForm(@PathVariable int id, Model model) {
        Doctor doctor = doctorService.getDoctorById(id);
        model.addAttribute("doctor", doctor);
        return "doctors/edit"; // Trả về trang chỉnh sửa bác sĩ
    }

    // Xử lý cập nhật bác sĩ
    @PostMapping("/update/{id}")
    public String updateDoctor(@PathVariable int id, @ModelAttribute("doctor") Doctor doctor) {
        doctor.setDoctorId(id);
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors"; // Chuyển hướng về trang danh sách bác sĩ
    }

    // Xử lý xoá bác sĩ
    @GetMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable int id) {
        doctorService.deleteDoctor(id);
        return "redirect:/doctors"; // Chuyển hướng về trang danh sách bác sĩ
    }
}
