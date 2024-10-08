package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public void saveDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public Doctor getDoctorById(int id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public void deleteDoctor(int id) {
        doctorRepository.deleteById(id);
    }
}
