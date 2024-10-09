package com.example.medicalservice.service;

import com.example.medicalservice.model.Patient;
import com.example.medicalservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deleteById(int id) {
        patientRepository.deleteById(id);
    }
}
