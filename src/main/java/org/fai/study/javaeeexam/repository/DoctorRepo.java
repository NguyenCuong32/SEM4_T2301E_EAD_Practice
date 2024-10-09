package org.fai.study.javaeeexam.repository;

import org.fai.study.javaeeexam.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {
}
