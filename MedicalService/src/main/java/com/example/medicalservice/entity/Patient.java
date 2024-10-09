package com.example.medicalservice.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int patientId;

    private String fullName;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private String gender;
    private String address;
    private String phoneNumber;
    private String email;

    // Getters and setters
}
