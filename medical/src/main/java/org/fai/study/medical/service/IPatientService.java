package org.fai.study.medical.service;

import org.fai.study.medical.entity.Patient;

import java.util.List;

public interface IPatientService {
    List<Patient> getAllPatients();
    Patient addPatient(Patient patient);
    Patient deletePatient(int patient_id);
    Patient updatePatient(Patient patient);
}
