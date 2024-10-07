package org.fai.study.btvn.service;

import org.fai.study.btvn.entity.Doctor;
import org.fai.study.btvn.entity.Patient;
import org.fai.study.btvn.repository.IAppointmentRepository;
import org.fai.study.btvn.repository.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DoctorService implements IDoctorService {

    @Autowired
    IDoctorRepository doctorRepository;


    @Override
    public List<Doctor> getDoctor() {
        var doctors = doctorRepository.findAll();
        return doctors;
    }
    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    @Override
    public Doctor getDoctorById(int id) {
        return doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    @Override
    public Doctor updateDoctor(int id, Doctor doctor) {
        Doctor doctor1 = doctorRepository.findById(id).orElse(null);
        if (doctor1 != null) {
            doctor1.setFullName(doctor.getFullName());
            doctor1.setSpecialization(doctor.getSpecialization());
            doctor1.setPhoneNumber(doctor.getPhoneNumber());
            doctor1.setEmail(doctor.getEmail());
            doctor1.setYearsOfExperience(doctor.getYearsOfExperience());
            return doctorRepository.save(doctor1);
        } else {
            return null;
        }
    }
    @Transactional
    @Override
    public void deleteDoctor(int id) {
        doctorRepository.deleteById(id);
    }
}
