package truong.assignment0910.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import truong.assignment0910.entity.Patients;

public interface PatientRepository extends JpaRepository<Patients,Integer> {
}
