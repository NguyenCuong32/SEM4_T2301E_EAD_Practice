package org.fai.study.medical.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id", nullable = false)
    private Integer doctor_id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "specialization", nullable = false, length = 100)
    private String specialization;

    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "years_of_experience")
    private Integer yearsOfExperience;

}