package org.fai.study.javaeeexam.service;

import org.fai.study.javaeeexam.entity.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    List<Doctor> findAllDoctors();
    Optional<Doctor> findDoctorById(Long id);
    void saveDoctor(Doctor doctor);
    void deleteDoctor(Long id);
}
