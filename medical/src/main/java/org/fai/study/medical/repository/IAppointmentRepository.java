package org.fai.study.medical.repository;

import org.fai.study.medical.entity.Appointment;
import org.fai.study.medical.entity.Doctor;
import org.fai.study.medical.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Integer> {
    void deleteByDoctor(Doctor doctor);
    void deleteByPatient(Patient patient);
}
