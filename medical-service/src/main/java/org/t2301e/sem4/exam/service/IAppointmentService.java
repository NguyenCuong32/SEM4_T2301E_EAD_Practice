package org.t2301e.sem4.exam.service;

import org.t2301e.sem4.exam.entity.Appointment;

import java.util.List;
import java.util.Optional;

public interface IAppointmentService {
    Appointment saveAppointment(Appointment appointment);
    Optional<Appointment> getAppointmentById(int id);
    List<Appointment> getAllAppointments();
    Appointment updateAppointment(int appointmentId, Appointment appointment);
    void deleteAppointment(int appointmentId);
    List<Appointment> getAppointmentsByPatientId(int patientId);
    List<Appointment> getAppointmentsByDoctorId(int doctorId);
}
