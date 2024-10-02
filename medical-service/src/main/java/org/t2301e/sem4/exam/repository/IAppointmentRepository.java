package org.t2301e.sem4.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.t2301e.sem4.exam.entity.Appointment;

import java.util.List;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Integer> {
    boolean existsByDoctor_DoctorId(int doctorId);

    boolean existsByPatient_PatientId(int patientId);

    List<Appointment> findByDoctor_DoctorId(int doctorId);

    List<Appointment> findByPatient_PatientId(int patientId);
}
