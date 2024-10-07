package org.fai.study.medical.service;

import jakarta.transaction.Transactional;
import org.fai.study.medical.entity.Appointment;
import org.fai.study.medical.entity.Doctor;
import org.fai.study.medical.entity.Patient;
import org.fai.study.medical.repository.IAppointmentRepository;
import org.fai.study.medical.repository.IDoctorRepository;
import org.fai.study.medical.repository.IPatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppoinmentService implements IAppointmentService {
    private final IAppointmentRepository appointmentRepository;

    private final IDoctorRepository doctorRepository;

    private final IPatientRepository patientRepository;

    public AppoinmentService(IAppointmentRepository appointmentRepository, IDoctorRepository doctorRepository, IPatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Appointment> getAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment addAppointment(Appointment appointment, int patientId, int doctorId) {
        // Tìm kiếm bệnh nhân dựa trên patientId
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient ID: " + patientId));

        // Tìm kiếm bác sĩ dựa trên doctorId
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid doctor ID: " + doctorId));

        // Thiết lập thông tin cho appointment
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        // Thiết lập trạng thái mặc định là 'pending' nếu không được cung cấp
        if (appointment.getStatus() == null || appointment.getStatus().isEmpty()) {
            appointment.setStatus("pending");
        }

        // Lưu appointment vào cơ sở dữ liệu
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointment(int appointmentId, Appointment updatedAppointment, int patientId, int doctorId) {
        Appointment existingAppointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid appointment ID: " + appointmentId));

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient ID: " + patientId));
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid doctor ID: " + doctorId));

        // Cập nhật thông tin
        existingAppointment.setPatient(patient);
        existingAppointment.setDoctor(doctor);
        existingAppointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
        existingAppointment.setReason(updatedAppointment.getReason());
        existingAppointment.setStatus(updatedAppointment.getStatus());

        return appointmentRepository.save(existingAppointment);
    }

    // Xóa Appointment
    @Override
    public void deleteAppointment(int appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid appointment ID: " + appointmentId));

        appointmentRepository.delete(appointment);
    }

}
