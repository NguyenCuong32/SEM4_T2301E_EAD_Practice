package org.t2301e.sem4.exam.service;

import org.t2301e.sem4.exam.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface IPatientService {

    Patient savePatient(Patient patient);

    Patient getPatientById(int id);

    List<Patient> getAllPatients();

    Patient updatePatient(int patientId, Patient patient);

    void deletePatient(int id);
}
