package org.t2301e.sem4.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.t2301e.sem4.exam.entity.Appointment;
import org.t2301e.sem4.exam.repository.IAppointmentRepository;
import org.t2301e.sem4.exam.repository.IDoctorRepository;
import org.t2301e.sem4.exam.repository.IPatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService implements IAppointmentService {

    @Autowired
    private IAppointmentRepository appointmentRepository;

    @Autowired
    private IDoctorRepository doctorRepository;

    @Autowired
    private IPatientRepository patientRepository;

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        if (!patientRepository.existsById(appointment.getPatient().getPatientId())) {
            throw new IllegalArgumentException("Patient does not exist.");
        }

        if (!doctorRepository.existsById(appointment.getDoctor().getDoctorId())) {
            throw new IllegalArgumentException("Doctor does not exist.");
        }

        return appointmentRepository.save(appointment);
    }

    @Override
    public Optional<Appointment> getAppointmentById(int id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment updateAppointment(int appointmentId, Appointment appointment) {
        Appointment existingAppointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found."));

        existingAppointment.setAppointmentDate(appointment.getAppointmentDate());
        existingAppointment.setReason(appointment.getReason());
        existingAppointment.setStatus(appointment.getStatus());

        return appointmentRepository.save(existingAppointment);
    }

    @Override
    public void deleteAppointment(int appointmentId) {
        if (!appointmentRepository.existsById(appointmentId)) {
            throw new IllegalArgumentException("Appointment not found.");
        }
        appointmentRepository.deleteById(appointmentId);
    }

    @Override
    public List<Appointment> getAppointmentsByPatientId(int patientId) {
        return appointmentRepository.findByPatient_PatientId(patientId);
    }

    @Override
    public List<Appointment> getAppointmentsByDoctorId(int doctorId) {
        return appointmentRepository.findByDoctor_DoctorId(doctorId);
    }

}
