package com.example.demo10.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class Doctor {


    @jakarta.persistence.Id
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String firstName;
        private String lastName;
        private String specialization;
        private String phoneNumber;
        private String email;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }




}
