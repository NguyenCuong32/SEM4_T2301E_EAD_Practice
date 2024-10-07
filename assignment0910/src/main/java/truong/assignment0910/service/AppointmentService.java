package truong.assignment0910.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import truong.assignment0910.entity.Appointments;
import truong.assignment0910.repository.AppointmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository AR;

    public List<Appointments> getAllAppointments() {return AR.findAll();}
    public Optional<Appointments> findAppointmentById(int id) {return AR.findById(id);}
    public void addAppointment(Appointments a) { AR.save(a);}
    public void deleteAppointment(int id) {AR.deleteById(id);}
}
