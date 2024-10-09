package org.fai.study.javaeeexam.entity.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {
    private String fullName;
    private String specialization;
    private String phoneNumber;
    private String email;
    private Integer yoe;
}
