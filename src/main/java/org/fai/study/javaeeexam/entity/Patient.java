package org.fai.study.javaeeexam.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    public Integer id;
    @Column(name = "full_name")
    public String fullName;
    @Column(name = "date_of_birth")
    public Date dob;
    public String gender;
    public String address;
    @Column(name = "phone_number")
    public String phoneNumber;
    public String email;

}
