package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;

    private String fullName;
    private Date dateOfBirth;
    private String gender;
    private String address;
    private String phoneNumber;
    private String email;

    // Getters và Setters
}
