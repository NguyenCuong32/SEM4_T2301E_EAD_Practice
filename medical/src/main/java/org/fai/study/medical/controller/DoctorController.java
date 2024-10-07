package org.fai.study.medical.controller;

import org.fai.study.medical.entity.Doctor;
import org.fai.study.medical.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private IDoctorService doctorService;

    @GetMapping("/doctorList")
    public String doctorList(Model model) {
        var doctorList = doctorService.getDoctors();
        model.addAttribute("doctors", doctorList);
        return "doctor/index";
    }

    @PostMapping("/addDoctor")
    public String addDoctor(@ModelAttribute Doctor doctor) {
        try{
            if(doctor != null){
                doctorService.addDoctor(doctor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/doctor/doctorList";
    }

    @PostMapping("/editDoctor")
    public String editDotor(@ModelAttribute Doctor doctor) {
        doctorService.updateDoctor(doctor);
        return "redirect:/doctor/doctorList";
    }

    @PostMapping("/deleteDoctor")
    public String deleteDoctor(@RequestParam int  doctor_id) {
        doctorService.deleteDoctor(doctor_id);
        return "redirect:/doctor/doctorList";
    }
}
