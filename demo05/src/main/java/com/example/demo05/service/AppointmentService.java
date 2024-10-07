package com.example.demo05.service;

import com.example.demo05.entity.Appointment;
import com.example.demo05.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Get all appointments
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();  // Correctly return a list of appointments
    }

    // Save an appointment
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);  // Save an Appointment
    }
}
