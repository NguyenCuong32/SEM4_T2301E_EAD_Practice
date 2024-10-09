package fpt.phunghoangvnuit.ead.asm.controller;

import fpt.phunghoangvnuit.ead.asm.model.Patient;
import fpt.phunghoangvnuit.ead.asm.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Get all patients
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    // Create a new patient
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    // Get a patient by ID
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable int id) {
        return patientService.getPatientById(id);
    }

    // Update a patient
    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable int id, @RequestBody Patient patientDetails) {
        return patientService.updatePatient(id, patientDetails);
    }

    // Delete a patient by ID
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable int id) {
        patientService.deletePatientById(id);
    }
}
