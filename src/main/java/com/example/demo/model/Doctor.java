package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;

    private String fullName;
    private String specialization;
    private String phoneNumber;
    private String email;
    private int yearsOfExperience;

    // Getters và Setters
}
