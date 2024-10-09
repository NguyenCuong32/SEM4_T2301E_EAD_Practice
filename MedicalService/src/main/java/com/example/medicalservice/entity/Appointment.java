package com.example.medicalservice.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int appointmentId;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    @Temporal(TemporalType.TIMESTAMP)
    private Date appointmentDate;
    private String reason;
    private String status = "pending";

    // Getters and setters
}
