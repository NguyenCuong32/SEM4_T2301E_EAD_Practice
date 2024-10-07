package truong.assignment0910.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import truong.assignment0910.entity.Appointments;

public interface AppointmentRepository extends JpaRepository<Appointments,Integer> {

}
