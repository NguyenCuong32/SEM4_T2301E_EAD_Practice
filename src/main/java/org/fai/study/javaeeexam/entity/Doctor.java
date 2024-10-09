package org.fai.study.javaeeexam.entity;

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
    public Integer id;
    @Column(name = "full_name")
    public String fullName;
    public String specialization;
    @Column(name = "phone_number")
    public String phoneNumber;
    public String email;
    @Column(name = "years_of_experience")
    public Integer yoe;
}
