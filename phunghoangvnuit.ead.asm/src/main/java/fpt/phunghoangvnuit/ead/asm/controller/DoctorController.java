package fpt.phunghoangvnuit.ead.asm.controller;

import fpt.phunghoangvnuit.ead.asm.model.Doctor;
import fpt.phunghoangvnuit.ead.asm.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Get all doctors
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    // Create a new doctor
    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    // Get a doctor by ID
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable int id) {
        return doctorService.getDoctorById(id);
    }

    // Update a doctor
    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable int id, @RequestBody Doctor doctorDetails) {
        return doctorService.updateDoctor(id, doctorDetails);
    }

    // Delete a doctor by ID
    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable int id) {
        doctorService.deleteDoctorById(id);
    }
}
