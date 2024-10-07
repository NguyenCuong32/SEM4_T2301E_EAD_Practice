package truong.assignment0910.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import truong.assignment0910.entity.Doctors;

public interface DoctorRepository extends JpaRepository<Doctors, Integer> {
}
