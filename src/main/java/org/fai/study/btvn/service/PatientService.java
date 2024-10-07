package org.fai.study.btvn.service;

import org.fai.study.btvn.entity.Doctor;
import org.fai.study.btvn.entity.Patient;
import org.fai.study.btvn.repository.IAppointmentRepository;
import org.fai.study.btvn.repository.IDoctorRepository;
import org.fai.study.btvn.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.List;

@Service
public class PatientService implements IPatientService {

    @Autowired
    IPatientRepository patientRepository;

    @Autowired
    IAppointmentRepository appointmentRepository;

    @Override
    public List<Patient> getPatient() {
        var patients = patientRepository.findAll();
        return patients;
    }
    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }
    @Override
    public Patient getPatientById(int id) {
        return patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }
    @Override
    public Patient updatePatient(int id, Patient patient) {
        Patient patient1 = patientRepository.findById(id).orElse(null);
        if (patient1 != null) {
            patient1.setFullName(patient.getFullName());
            patient1.setDateOfBirth(patient.getDateOfBirth());
            patient1.setGender(patient.getGender());
            patient1.setAddress(patient.getAddress());
            patient1.setPhoneNumber(patient.getPhoneNumber());
            patient1.setEmail(patient.getEmail());
            return patientRepository.save(patient1);
        } else {
            return null;
        }
    }
    @Transactional
    @Override
    public void deletePatient(int id) {
        patientRepository.deleteById(id);
    }
}
