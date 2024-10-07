package org.fai.study.btvn.controller;

import org.fai.study.btvn.entity.Doctor;
import org.fai.study.btvn.entity.Patient;
import org.fai.study.btvn.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping()
    public String getPatients(Model model) {
        List<Patient> patients = patientService.getPatient();
        model.addAttribute("patients", patients);
        return "patient/patient";
    }

    @PostMapping("/add")
    public String addNewStudent(@ModelAttribute Patient patient) {
        patientService.addPatient(patient);
        return "redirect:/patients";
    }
    @GetMapping("/update/{id}")
    public String updatePatient(@PathVariable int id, Model model) {
        Patient patient = patientService.getPatientById(id);
        if (patient != null) {
            model.addAttribute("patient", patient);
        }
        return "patient/edit";
    }

    @PostMapping("/update/{id}")
    public String updatePatient(@PathVariable int id, @ModelAttribute Patient patient) {
        patientService.updatePatient(id, patient);
        return "redirect:/patients";
    }

    @PostMapping("/delete{id}")
    public String deletePatient(@PathVariable int id) {
        patientService.deletePatient(id);
        return "redirect:/patients";
    }
}
