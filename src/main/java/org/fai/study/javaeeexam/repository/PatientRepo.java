package org.fai.study.javaeeexam.repository;

import org.fai.study.javaeeexam.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {

}
