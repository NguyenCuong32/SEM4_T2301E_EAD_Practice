package org.t2301e.sem4.exam.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private int doctorId;

    @Column(name = "full_name", nullable = false, length = 255)
    private String fullName;

    @Column(nullable = false, length = 100)
    private String specialization;

    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @Column(length = 100)
    private String email;

    @Column(name = "years_of_experience")
    private Integer yearsOfExperience;
}
