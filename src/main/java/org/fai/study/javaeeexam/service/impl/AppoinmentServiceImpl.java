package org.fai.study.javaeeexam.service.impl;

import org.fai.study.javaeeexam.entity.DTOs.AppoinmentDTO;
import org.fai.study.javaeeexam.repository.AppoinmentRepo;
import org.fai.study.javaeeexam.service.AppoinmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppoinmentServiceImpl implements AppoinmentService {
    @Autowired
    AppoinmentRepo appoinmentRepo;

    @Override
    public List<AppoinmentDTO> getAllAppoinmentsInfor() {
        return appoinmentRepo.getAllAppoinmentDetail();
    }
}
