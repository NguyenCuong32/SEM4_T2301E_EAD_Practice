package org.fai.study.btvn.repository;

import org.fai.study.btvn.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phone);
}
