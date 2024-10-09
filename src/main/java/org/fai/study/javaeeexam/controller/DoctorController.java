package org.fai.study.javaeeexam.controller;

import org.fai.study.javaeeexam.entity.DTOs.DoctorDTO;
import org.fai.study.javaeeexam.entity.DTOs.EditDoctorDTO;
import org.fai.study.javaeeexam.entity.Doctor;
import org.fai.study.javaeeexam.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @GetMapping("/doctor")
    public String getDoctors(Model model) {
        List<Doctor> doctorList = doctorService.findAllDoctors();
        model.addAttribute("doctorList", doctorList);
        model.addAttribute("doctorDTO", new DoctorDTO());
        return "/index/doctor";
    }

    @PostMapping("/postDoctor")
    public String addDoctor(@ModelAttribute DoctorDTO doctorDTO, Model model) {
        Doctor doctor = new Doctor();
        // Gán giá trị từ doctorDTO vào doctor
        doctor.setFullName(doctorDTO.getFullName());
        doctor.setSpecialization(doctorDTO.getSpecialization());
        doctor.setPhoneNumber(doctorDTO.getPhoneNumber());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setYoe(doctorDTO.getYoe());

        doctorService.saveDoctor(doctor);
        return "redirect:/api/v1/doctor"; // Chuyển hướng về trang danh sách bác sĩ
    }

    @GetMapping("/doctor/edit/{id}")
    public String editDoctor(@PathVariable Long id, Model model) {
        Doctor doctor = doctorService.findDoctorById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
        model.addAttribute("doctorDTO", doctor);
        return "/index/editDoctor"; // Trang chỉnh sửa
    }

    @PostMapping("/doctor/update")
    public String updateDoctor(@ModelAttribute EditDoctorDTO doctorDTO) {
        // Tìm bác sĩ hiện có bằng ID
        Doctor existingDoctor = doctorService.findDoctorById(doctorDTO.getId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        // Cập nhật thông tin bác sĩ hiện có
        existingDoctor.setFullName(doctorDTO.getFullName());
        existingDoctor.setSpecialization(doctorDTO.getSpecialization());
        existingDoctor.setPhoneNumber(doctorDTO.getPhoneNumber());
        existingDoctor.setEmail(doctorDTO.getEmail());
        existingDoctor.setYoe(doctorDTO.getYoe());

        // Lưu lại thông tin đã cập nhật
        doctorService.saveDoctor(existingDoctor);
        return "redirect:/api/v1/doctor"; // Chuyển hướng về trang danh sách bác sĩ
    }


    @GetMapping("/doctor/delete/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return "redirect:/api/v1/doctor"; // Chuyển hướng về trang danh sách bác sĩ
    }




}
