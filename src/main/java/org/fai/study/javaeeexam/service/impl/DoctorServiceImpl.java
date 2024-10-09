package org.fai.study.javaeeexam.service.impl;

import org.fai.study.javaeeexam.entity.Doctor;
import org.fai.study.javaeeexam.repository.DoctorRepo;
import org.fai.study.javaeeexam.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    @Override
    public List<Doctor> findAllDoctors() {

            List<Doctor> doctors = doctorRepo.findAll();
            return doctors;

    }

    @Override
    public Optional<Doctor> findDoctorById(Long id) {

            return doctorRepo.findById(id);
    }

    @Override
    public void saveDoctor(Doctor doctor) {
        try {
            doctorRepo.save(doctor);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Fail to save doctor");
        }

    }

    @Override
    public void deleteDoctor(Long id) {
        try {
            doctorRepo.deleteById(id);
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("Fail to delete doctor by id");
        }
    }

}
