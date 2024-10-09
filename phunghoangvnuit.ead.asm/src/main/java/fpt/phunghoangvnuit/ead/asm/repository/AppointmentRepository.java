package fpt.phunghoangvnuit.ead.asm.repository;

import fpt.phunghoangvnuit.ead.asm.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {}
