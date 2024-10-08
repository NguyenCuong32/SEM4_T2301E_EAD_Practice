package com.example.homework.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String specialization;

    private String phoneNumber;
    private String email;
    private Integer yearsOfExperience;


    public Doctor(Integer doctorId, String email, String fullName, String specialization, Integer yearsOfExperience, String phoneNumber) {
        this.doctorId = doctorId;
        this.email = email;
        this.fullName = fullName;
        this.specialization = specialization;
        this.yearsOfExperience = yearsOfExperience;
        this.phoneNumber = phoneNumber;
    }

    public Doctor() {

    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}