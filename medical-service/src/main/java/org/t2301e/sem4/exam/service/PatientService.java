package org.t2301e.sem4.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.t2301e.sem4.exam.entity.Patient;
import org.t2301e.sem4.exam.repository.IAppointmentRepository;
import org.t2301e.sem4.exam.repository.IPatientRepository;

import java.util.List;

@Service
public class PatientService implements IPatientService {

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    private IAppointmentRepository appointmentRepository;

    @Override
    public Patient savePatient(Patient patient) {
        if (patientRepository.existsByEmail(patient.getEmail())) {
            throw new IllegalArgumentException("A patient with this email already exists.");
        }

        if (patientRepository.existsByPhoneNumber(patient.getPhoneNumber())) {
            throw new IllegalArgumentException("A patient with this number already exists.");
        }

        if (patient.getDateOfBirth() != null && patient.getDateOfBirth().isAfter(java.time.LocalDate.now())) {
            throw new IllegalArgumentException("Date of birth cannot be in the future.");
        }

        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(int id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found."));
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient updatePatient(int patientId, Patient patient) {
        Patient existingPatient = patientRepository.findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found."));

        if (!existingPatient.getEmail().equals(patient.getEmail()) &&
                patientRepository.existsByEmail(patient.getEmail())) {
            throw new IllegalArgumentException("A patient with this email already exists.");
        }

        if (!existingPatient.getEmail().equals(patient.getEmail()) &&
                patientRepository.existsByEmail(patient.getEmail())) {
            throw new IllegalArgumentException("A patient with this email already exists.");
        }

        if (patient.getDateOfBirth() != null && patient.getDateOfBirth().isAfter(java.time.LocalDate.now())) {
            throw new IllegalArgumentException("Date of birth cannot be in the future.");
        }

        if (patient.getFullName() != null) {
            existingPatient.setFullName(patient.getFullName());
        }
        if (patient.getDateOfBirth() != null) {
            existingPatient.setDateOfBirth(patient.getDateOfBirth());
        }
        if (patient.getGender() != null) {
            existingPatient.setGender(patient.getGender());
        }
        if (patient.getAddress() != null) {
            existingPatient.setAddress(patient.getAddress());
        }
        if (patient.getPhoneNumber() != null) {
            existingPatient.setPhoneNumber(patient.getPhoneNumber());
        }

        return patientRepository.save(existingPatient);
    }

    @Override
    public void deletePatient(int id) {
        if (appointmentRepository.existsByPatient_PatientId(id)) {
            throw new IllegalArgumentException("Patient has active appointments and cannot be deleted.");
        }
        patientRepository.deleteById(id);
    }
}
