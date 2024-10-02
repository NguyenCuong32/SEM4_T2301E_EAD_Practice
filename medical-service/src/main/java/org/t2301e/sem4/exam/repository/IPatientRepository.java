package org.t2301e.sem4.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.t2301e.sem4.exam.entity.Patient;

import java.time.LocalDate;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer> {
    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phone);
}
