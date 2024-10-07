package org.fai.study.medical.service;

import jakarta.transaction.Transactional;
import org.fai.study.medical.entity.Patient;
import org.fai.study.medical.repository.IAppointmentRepository;
import org.fai.study.medical.repository.IPatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class PatientService implements IPatientService{
    final
    IPatientRepository patientRepository;
    final
    IAppointmentRepository appointmentRepository;

    public PatientService(IPatientRepository patientRepository, IAppointmentRepository appointmentRepository) {
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    @Transactional
    public Patient updatePatient(Patient patient) {
        if (patient.getPatient_id() == null) {
            throw new IllegalArgumentException("Patient ID must not be null.");
        }
        return patientRepository.save(patient);
    }

    @Override
    @Transactional
    public Patient deletePatient(int patient_id) {
        Patient patient = patientRepository.findById(patient_id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient ID: " + patient_id));

        appointmentRepository.deleteByPatient(patient);

        patientRepository.deleteById(patient_id);

        return patient;
    }

}
