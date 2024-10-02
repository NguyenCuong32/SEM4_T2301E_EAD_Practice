package org.t2301e.sem4.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.t2301e.sem4.exam.entity.Doctor;
import org.t2301e.sem4.exam.repository.IDoctorRepository;
import org.t2301e.sem4.exam.repository.IAppointmentRepository;

import java.util.List;

@Service
public class DoctorService implements IDoctorService {

    @Autowired
    private IDoctorRepository doctorRepository;

    @Autowired
    private IAppointmentRepository appointmentRepository;

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        if (doctorRepository.existsByEmail(doctor.getEmail())) {
            throw new IllegalArgumentException("A doctor with this email already exists.");
        }

        if (doctorRepository.existsByPhoneNumber(doctor.getPhoneNumber())) {
            throw new IllegalArgumentException("A doctor with this number already exists.");
        }

        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor getDoctorById(int id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found."));
    }


    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor updateDoctor(int doctorId, Doctor doctor) {
        Doctor existingDoctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found."));

        if (!existingDoctor.getEmail().equals(doctor.getEmail()) &&
                doctorRepository.existsByEmail(doctor.getEmail())) {
            throw new IllegalArgumentException("A doctor with this email already exists.");
        }

        if (!existingDoctor.getPhoneNumber().equals(doctor.getPhoneNumber()) &&
                doctorRepository.existsByPhoneNumber(doctor.getPhoneNumber())) {
            throw new IllegalArgumentException("A doctor with this number already exists.");
        }

        if (doctor.getFullName() != null) {
            existingDoctor.setFullName(doctor.getFullName());
        }
        if (doctor.getSpecialization() != null) {
            existingDoctor.setSpecialization(doctor.getSpecialization());
        }
        if (doctor.getPhoneNumber() != null) {
            existingDoctor.setPhoneNumber(doctor.getPhoneNumber());
        }
        if (doctor.getEmail() != null) {
            existingDoctor.setEmail(doctor.getEmail());
        }
        if (doctor.getYearsOfExperience() != null) {
            existingDoctor.setYearsOfExperience(doctor.getYearsOfExperience());
        }

        return doctorRepository.save(existingDoctor);
    }

    @Override
    public void deleteDoctor(int id) {
        if (appointmentRepository.existsByDoctor_DoctorId(id)) {
            throw new IllegalArgumentException("Doctor has active appointments and cannot be deleted.");
        }
        doctorRepository.deleteById(id);
    }
}
