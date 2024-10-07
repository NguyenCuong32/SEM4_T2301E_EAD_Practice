package org.fai.study.medical.service;

import org.fai.study.medical.entity.Appointment;

import java.util.List;

public interface IAppointmentService {
    List<Appointment> getAppointments();
    Appointment addAppointment(Appointment appointment, int patientId, int doctorId);
    Appointment updateAppointment(int appointmentId, Appointment updatedAppointment, int patientId, int doctorId);
    void deleteAppointment(int appointmentId);
}
