package truong.assignment0910.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "doctors")
public class Doctors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int doctor_id;

    @Column(nullable = false)
    private String full_name;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_of_birth;

    private String phone_number;
    private String email;
    private int years_of_experience;

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getYears_of_experience() {
        return years_of_experience;
    }

    public void setYears_of_experience(int years_of_experience) {
        this.years_of_experience = years_of_experience;
    }



    @Override
    public String toString() {
        return "Doctors{" +
                "doctor_id=" + doctor_id +
                ", full_name='" + full_name + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", years_of_experience=" + years_of_experience +
                '}';
    }
}
