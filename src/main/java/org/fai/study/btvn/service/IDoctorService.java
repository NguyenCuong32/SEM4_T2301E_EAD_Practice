package org.fai.study.btvn.service;

import org.fai.study.btvn.entity.Doctor;
import org.fai.study.btvn.entity.Patient;

import java.util.List;

public interface IDoctorService {
    List<Doctor> getDoctor();
    Doctor addDoctor(Doctor doctor);
    Doctor getDoctorById(int id);
    Doctor updateDoctor(int id, Doctor doctor);
    void deleteDoctor(int id);
}
