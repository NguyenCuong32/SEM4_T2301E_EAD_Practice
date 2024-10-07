package org.fai.study.medical.service;

import org.fai.study.medical.entity.Doctor;

import java.util.List;

public interface IDoctorService {
    List<Doctor> getDoctors();
    Doctor addDoctor(Doctor doctor);
    Doctor updateDoctor(Doctor doctor);
    Doctor deleteDoctor(int doctor_id);
}
