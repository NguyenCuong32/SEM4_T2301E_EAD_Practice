package org.fai.study.btvn.service;

import org.fai.study.btvn.entity.Doctor;
import org.fai.study.btvn.entity.Patient;

import java.util.List;

public interface IPatientService {

    List<Patient> getPatient();
    Patient addPatient(Patient patient);
    Patient getPatientById(int id);
    Patient updatePatient(int id, Patient patient);
    void deletePatient(int id);
}
