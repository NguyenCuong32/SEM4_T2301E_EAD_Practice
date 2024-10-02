package org.t2301e.sem4.exam.service;

import org.t2301e.sem4.exam.entity.Doctor;

import java.util.List;

public interface IDoctorService {

    Doctor saveDoctor(Doctor doctor);

    Doctor getDoctorById(int id);

    List<Doctor> getAllDoctors();

    Doctor updateDoctor(int doctorId, Doctor doctor);

    void deleteDoctor(int id);
}
