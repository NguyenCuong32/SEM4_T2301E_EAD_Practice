package org.fai.study.medical.service;

import jakarta.transaction.Transactional;
import org.fai.study.medical.entity.Appointment;
import org.fai.study.medical.entity.Doctor;
import org.fai.study.medical.repository.IAppointmentRepository;
import org.fai.study.medical.repository.IDoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService implements IDoctorService {
    final
    IDoctorRepository doctorRepository;

    final
    IAppointmentRepository appointmentRepository;

    public DoctorService(IDoctorRepository doctorRepository ,IAppointmentRepository appointmentRepository) {
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        try{
            if (doctor != null && doctorRepository.existsById(doctor.getDoctor_id())) {
                return doctorRepository.save(doctor);
            }
        } catch (Exception e) {
            e.setStackTrace(e.getStackTrace());
        }
        return null;
    }

    @Override
    @Transactional
    public Doctor deleteDoctor(int doctor_id) {
        Doctor doctor = doctorRepository.findById(doctor_id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid doctor ID: " + doctor_id));

        appointmentRepository.deleteByDoctor(doctor);

        doctorRepository.deleteById(doctor_id);

        return doctor;
    }

}
