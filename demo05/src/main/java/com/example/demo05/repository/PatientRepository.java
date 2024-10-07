package com.example.demo05.repository;
import com.example.demo05.entity.Patient;
import com.example.demo05.entity.Doctor;
import com.example.demo05.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
