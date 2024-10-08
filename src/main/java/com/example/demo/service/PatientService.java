package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    public Patient getPatientById(int id) {
        return patientRepository.findById(id).orElse(null);
    }

    public void deletePatient(int id) {
        patientRepository.deleteById(id);
    }
}
