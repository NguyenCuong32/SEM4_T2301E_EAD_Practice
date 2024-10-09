package fpt.phunghoangvnuit.ead.asm.controller;

import fpt.phunghoangvnuit.ead.asm.model.Appointment;
import fpt.phunghoangvnuit.ead.asm.model.Doctor;
import fpt.phunghoangvnuit.ead.asm.model.Patient;
import fpt.phunghoangvnuit.ead.asm.service.AppointmentService;
import fpt.phunghoangvnuit.ead.asm.repository.DoctorRepository;
import fpt.phunghoangvnuit.ead.asm.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    // Get all appointments
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // Create a new appointment
    @PostMapping
    public Appointment createAppointment(@RequestBody Map<String, Object> appointmentData) {
        int doctorId = (int) appointmentData.get("doctorId");
        int patientId = (int) appointmentData.get("patientId");

        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(LocalDateTime.parse((String) appointmentData.get("appointmentDate")));
        appointment.setReason((String) appointmentData.get("reason"));
        appointment.setStatus((String) appointmentData.get("status"));

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        return appointmentService.saveAppointment(appointment);
    }

    // Get an appointment by ID
    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable int id) {
        return appointmentService.getAppointmentById(id);
    }

    // Update an appointment
    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable int id, @RequestBody Map<String, Object> appointmentData) {
        int doctorId = (int) appointmentData.get("doctorId");
        int patientId = (int) appointmentData.get("patientId");

        Appointment appointmentDetails = new Appointment();
        appointmentDetails.setAppointmentDate(LocalDateTime.parse((String) appointmentData.get("appointmentDate")));
        appointmentDetails.setReason((String) appointmentData.get("reason"));
        appointmentDetails.setStatus((String) appointmentData.get("status"));

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        appointmentDetails.setDoctor(doctor);
        appointmentDetails.setPatient(patient);

        return appointmentService.updateAppointment(id, appointmentDetails);
    }

    // Delete an appointment by ID
    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable int id) {
        appointmentService.deleteAppointmentById(id);
    }
}
