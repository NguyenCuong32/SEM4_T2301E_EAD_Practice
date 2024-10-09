package com.example.medicalservice.model;

import javax.persistence.*;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int doctorId;

    private String fullName;
    private String specialization;
    private String phoneNumber;
    private String email;
    private int yearsOfExperience;

    // Getters and setters
}
