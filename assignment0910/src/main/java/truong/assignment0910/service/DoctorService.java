package truong.assignment0910.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import truong.assignment0910.entity.Doctors;
import truong.assignment0910.repository.DoctorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository DR;

    public List<Doctors> getAllDoctors() {return DR.findAll();}
    public void addDoctor(Doctors d) {DR.save(d);}
    public void deleteDoctor(Doctors d) {DR.delete(d);}
    public Optional<Doctors> getDoctorById(int doctor_id)
    {return DR.findById(doctor_id);
    }
}
