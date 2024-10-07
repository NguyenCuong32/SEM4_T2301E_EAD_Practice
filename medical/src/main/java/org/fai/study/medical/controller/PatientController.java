package org.fai.study.medical.controller;

import org.fai.study.medical.entity.Patient;
import org.fai.study.medical.service.IPatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/patient")
public class PatientController {
    private final IPatientService patientService;

    public PatientController(IPatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patientList")
    public String patientList(Model model) {
        var patientList = patientService.getAllPatients();
        model.addAttribute("patients", patientList);
        return "patient/index";
    }

    @PostMapping("/addPatient")
    public String addPatient(@ModelAttribute Patient patient) {
        try{
            if(patient != null){
                patientService.addPatient(patient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/patient/patientList";
    }

    @PostMapping("/updatePatient")
    public String updatePatient(@ModelAttribute Patient patient) {
        patientService.updatePatient(patient);
        return "redirect:/patient/patientList";
    }

    @PostMapping("/deletePatient")
    public String deletePatient(@RequestParam int patient_id) {
        patientService.deletePatient(patient_id);
        return "redirect:/patient/patientList";
    }

}
