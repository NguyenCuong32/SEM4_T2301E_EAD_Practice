package fpt.phunghoangvnuit.ead.asm.service;

import fpt.phunghoangvnuit.ead.asm.model.Appointment;
import fpt.phunghoangvnuit.ead.asm.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Get all appointments
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // Save a new appointment
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    // Get an appointment by ID
    public Appointment getAppointmentById(int id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    // Update an appointment
    public Appointment updateAppointment(int id, Appointment appointmentDetails) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointment.setAppointmentDate(appointmentDetails.getAppointmentDate());
        appointment.setReason(appointmentDetails.getReason());
        appointment.setStatus(appointmentDetails.getStatus());
        appointment.setDoctor(appointmentDetails.getDoctor());
        appointment.setPatient(appointmentDetails.getPatient());

        return appointmentRepository.save(appointment);
    }

    // Delete an appointment by ID
    public void deleteAppointmentById(int id) {
        appointmentRepository.deleteById(id);
    }
}
