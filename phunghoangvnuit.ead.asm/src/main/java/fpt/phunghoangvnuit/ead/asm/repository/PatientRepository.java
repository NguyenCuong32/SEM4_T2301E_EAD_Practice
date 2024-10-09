package fpt.phunghoangvnuit.ead.asm.repository;

import fpt.phunghoangvnuit.ead.asm.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {}
