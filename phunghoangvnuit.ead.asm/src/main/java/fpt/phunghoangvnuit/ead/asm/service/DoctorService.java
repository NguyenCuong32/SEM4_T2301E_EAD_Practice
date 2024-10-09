package fpt.phunghoangvnuit.ead.asm.service;

import fpt.phunghoangvnuit.ead.asm.model.Doctor;
import fpt.phunghoangvnuit.ead.asm.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // Method to get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Method to save a new doctor
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // Method to find a doctor by ID
    public Doctor getDoctorById(int id) {
        return doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    // Method to update an existing doctor
    public Doctor updateDoctor(int id, Doctor doctorDetails) {
        Doctor doctor = getDoctorById(id);
        doctor.setFullName(doctorDetails.getFullName());
        doctor.setSpecialization(doctorDetails.getSpecialization());
        doctor.setPhoneNumber(doctorDetails.getPhoneNumber());
        doctor.setEmail(doctorDetails.getEmail());
        doctor.setYearsOfExperience(doctorDetails.getYearsOfExperience());
        return doctorRepository.save(doctor);
    }

    // Method to delete a doctor by ID
    public void deleteDoctorById(int id) {
        doctorRepository.deleteById(id);
    }
}
