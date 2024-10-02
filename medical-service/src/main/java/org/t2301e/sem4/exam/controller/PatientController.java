package org.t2301e.sem4.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.t2301e.sem4.exam.entity.Patient;
import org.t2301e.sem4.exam.service.IPatientService;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private IPatientService patientService;

    @GetMapping
    public String listPatients(Model model) {
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        return "patient/list";
    }

    @GetMapping("/create")
    public String createPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient/create";
    }

    @PostMapping
    public String savePatient(@ModelAttribute Patient patient, Model model) {
        try {
            patientService.savePatient(patient);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "patient/create";
        }
        return "redirect:/patients";
    }
;
    @GetMapping("/edit/{id}")
    public String editPatientForm(@PathVariable("id") int id, Model model) {
        Patient patient = patientService.getPatientById(id);
        model.addAttribute("patient", patient);
        return "patient/edit";
    }

    @PostMapping("/edit/{id}")
    public String updatePatient(@PathVariable("id") int id,
                                @ModelAttribute Patient patient,
                                Model model
    ) {
        try {
            patientService.updatePatient(id, patient);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("patient", patient);
            return "patient/edit";
        }
        return "redirect:/patients";
    }

    @PostMapping("/delete/{id}")
    public String deletePatient(@PathVariable("id") int id) {
        patientService.deletePatient(id);
        return "redirect:/patients";
    }
}
