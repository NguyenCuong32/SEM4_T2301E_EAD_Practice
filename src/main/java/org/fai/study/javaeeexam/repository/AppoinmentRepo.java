package org.fai.study.javaeeexam.repository;

import org.fai.study.javaeeexam.entity.Appointment;
import org.fai.study.javaeeexam.entity.DTOs.AppoinmentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppoinmentRepo extends JpaRepository<Appointment,Long> {
    @Query("SELECT new org.fai.study.javaeeexam.entity.DTOs.AppoinmentDTO(a.id,concat(d.fullName, ' - ', d. specialization) ,p.fullName,a.appointment_date,a.reason,a.status) " +
            "from Appointment a " +
            "join Doctor d on a.doctor_id = d.id " +
            "join Patient p on a.patient_id = p.id")
    List<AppoinmentDTO> getAllAppoinmentDetail();
}
