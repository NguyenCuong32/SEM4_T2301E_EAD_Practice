package org.fai.study.javaeeexam.controller;

import org.fai.study.javaeeexam.entity.DTOs.AppoinmentDTO;
import org.fai.study.javaeeexam.service.AppoinmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/v1")
public class AppoinmentController {

    @Autowired
    AppoinmentService appoinmentService;

    @GetMapping("/appoinment")
    public String appoinment(Model model) {
        List<AppoinmentDTO> appoinmentDTOList = appoinmentService.getAllAppoinmentsInfor();
        model.addAttribute("appoinmentList", appoinmentDTOList);
        return "/index/index1";
    }
}
