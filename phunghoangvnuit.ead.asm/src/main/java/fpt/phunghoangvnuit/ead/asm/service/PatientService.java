package fpt.phunghoangvnuit.ead.asm.service;

import fpt.phunghoangvnuit.ead.asm.model.Patient;
import fpt.phunghoangvnuit.ead.asm.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Method to get all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Method to save a new patient
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Method to find a patient by ID
    public Patient getPatientById(int id) {
        return patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    // Method to update an existing patient
    public Patient updatePatient(int id, Patient patientDetails) {
        Patient patient = getPatientById(id);
        patient.setFullName(patientDetails.getFullName());
        patient.setDateOfBirth(patientDetails.getDateOfBirth());
        patient.setGender(patientDetails.getGender());
        patient.setAddress(patientDetails.getAddress());
        patient.setPhoneNumber(patientDetails.getPhoneNumber());
        patient.setEmail(patientDetails.getEmail());
        return patientRepository.save(patient);
    }

    // Method to delete a patient by ID
    public void deletePatientById(int id) {
        patientRepository.deleteById(id);
    }
}