package truong.assignment0910.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import truong.assignment0910.entity.Doctors;
import truong.assignment0910.entity.Patients;
import truong.assignment0910.repository.PatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    PatientRepository PR;

    public List<Patients> getAllPatients() { return PR.findAll();}
    public Optional<Patients> getPatientById(int id) { return PR.findById(id); }
    public void addPatient(Patients p) {PR.save(p);}
    public void deletePatient(Patients p) {PR.delete(p);}


}
