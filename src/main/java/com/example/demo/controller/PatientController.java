package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Hiển thị danh sách bệnh nhân
    @GetMapping
    public String listPatients(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());
        return "patients/index"; // Trả về trang danh sách bệnh nhân
    }

    // Hiển thị form thêm bệnh nhân mới
    @GetMapping("/new")
    public String showNewPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patients/new"; // Trả về trang thêm bệnh nhân mới
    }

    // Xử lý thêm mới bệnh nhân
    @PostMapping
    public String savePatient(@ModelAttribute("patient") Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/patients"; // Chuyển hướng về trang danh sách bệnh nhân
    }

    // Hiển thị form chỉnh sửa bệnh nhân
    @GetMapping("/edit/{id}")
    public String showEditPatientForm(@PathVariable int id, Model model) {
        Patient patient = patientService.getPatientById(id);
        model.addAttribute("patient", patient);
        return "patients/edit"; // Trả về trang chỉnh sửa bệnh nhân
    }

    // Xử lý cập nhật bệnh nhân
    @PostMapping("/update/{id}")
    public String updatePatient(@PathVariable int id, @ModelAttribute("patient") Patient patient) {
        patient.setPatientId(id);
        patientService.savePatient(patient);
        return "redirect:/patients"; // Chuyển hướng về trang danh sách bệnh nhân
    }

    // Xử lý xoá bệnh nhân
    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable int id) {
        patientService.deletePatient(id);
        return "redirect:/patients"; // Chuyển hướng về trang danh sách bệnh nhân
    }
}
