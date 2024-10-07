package org.fai.study.btvn.service;

import org.fai.study.btvn.entity.Appointment;


import java.util.List;

public interface IAppointmentService {
    List<Appointment> getAppointments();
    Appointment getAppointmentbyId(int id);
    Appointment addAppointment(Appointment appointment);
    Appointment updateAppointment(int appointmentId, Appointment appointment);
    void deleteAppointment(int appointmentId);
}
