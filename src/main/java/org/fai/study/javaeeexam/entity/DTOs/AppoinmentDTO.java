package org.fai.study.javaeeexam.entity.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fai.study.javaeeexam.entity.Status;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppoinmentDTO {
    private int id;
    private String docName;
    private String patientName;
    private Date date;
    private String reason;
    private String status;
}
