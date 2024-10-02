package org.t2301e.sem4.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.t2301e.sem4.exam.entity.Doctor;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phone);
}
