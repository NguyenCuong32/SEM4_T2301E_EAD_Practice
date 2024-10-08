package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Appointment;
import com.example.demo.repository.AppointmentRepository;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public void saveAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public Appointment getAppointmentById(int id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    public void deleteAppointment(int id) {
        appointmentRepository.deleteById(id);
    }
}
