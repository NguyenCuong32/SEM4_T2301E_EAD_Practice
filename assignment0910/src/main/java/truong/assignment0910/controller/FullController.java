package truong.assignment0910.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import truong.assignment0910.entity.Appointments;
import truong.assignment0910.entity.Doctors;
import truong.assignment0910.entity.Patients;
import truong.assignment0910.service.AppointmentService;
import truong.assignment0910.service.DoctorService;
import truong.assignment0910.service.PatientService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class FullController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private AppointmentService appointmentService;

    // DoctorCRUD

    @GetMapping("/doctors")
    public String getAllDoctors(Model model) {
        List<Doctors> doctors = doctorService.getAllDoctors();
        model.addAttribute("doctors", doctors);
        return "doctor";
    }

    @GetMapping("/doctors/add")
    public String showAddDoctorForm(Model model) {
        model.addAttribute("newDoctor", new Doctors());
        return "addDoctorPage";
    }

    @PostMapping("/doctors/add")
    public String addDoctor(@ModelAttribute Doctors doctor) {
        doctorService.addDoctor(doctor);
        return "redirect:/api/doctors";
    }

    @GetMapping("/doctors/edit/{id}")
    public String showEditDoctorForm(@PathVariable int id, Model model) {
        Optional<Doctors> doctor = doctorService.getDoctorById(id);
        if (doctor.isPresent()) {
            model.addAttribute("doctor", doctor.get());
            return "editDoctorPage";
        } else {
            return "redirect:/api/doctors";
        }
    }

    @PostMapping("/doctors/edit/{id}")
    public String updateDoctor(@PathVariable int id, @ModelAttribute Doctors doctor, Model model) {
        doctor.setDoctor_id(id);
        doctorService.addDoctor(doctor);
//        model.addAttribute("doctor",doctor);
        return "redirect:/api/doctors";
    }

    @PostMapping("/doctors/delete/{id}")
    public String deleteDoctor(@PathVariable int id) {
        doctorService.deleteDoctor(doctorService.getDoctorById(id).orElseThrow());
        return "redirect:/api/doctors";
    }








    // PatientCRUD
    @GetMapping("/patients")
    public String getAllPatients(Model model) {
        List<Patients> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        return "patient";
    }

    @GetMapping("patients/add")
    public String showAddPatientForm(Model model) {
        model.addAttribute("newPatient", new Patients());
        return "addPatientPage";
    }

    @PostMapping("patients/add")
    public String addPatient(@ModelAttribute Patients patient) {
        patientService.addPatient(patient);
        return "redirect:/api/patients";
    }


    @GetMapping("patients/edit/{id}")
    public String showEditPatientForm(@PathVariable int id, Model model) {
        Optional<Patients> patient = patientService.getPatientById(id);
        if (patient.isPresent()) {
            model.addAttribute("patient", patient.get());
            return "editPatientPage";
        } else {
            return "redirect:/api/patients";
        }
    }

    @PostMapping("patients/edit/{id}")
    public String updatePatient(@PathVariable int id, @ModelAttribute Patients patient) {
        patient.setPatient_id(id);
        patientService.addPatient(patient);
        return "redirect:/api/patients";
    }

    @PostMapping("patients/delete/{id}")
    public String deletePatient(@PathVariable int id) {
        patientService.deletePatient(patientService.getPatientById(id).orElseThrow());
        return "redirect:/api/patients";
    }









    // AppointmentCRUD
    @GetMapping("/appointments")
    public String getAllAppointments(Model model) {
        List<Appointments> appointments = appointmentService.getAllAppointments();
        model.addAttribute("appointments", appointments);
        return "appointment";
    }

    @GetMapping("/appointments/add")
    public String showAddAppointmentForm(Model model) {
        model.addAttribute("newAppointment", new Appointments());
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "addAppointmentPage";
    }

    @PostMapping("/appointments/add")
    public String addAppointment(@ModelAttribute Appointments appointment) {
        appointment.setPatient(patientService.getPatientById(appointment.getPatient().getPatient_id()).orElse(null));
        appointment.setDoctor(doctorService.getDoctorById(appointment.getDoctor().getDoctor_id()).orElse(null));
        appointmentService.addAppointment(appointment);
        return "redirect:/api/appointments";
    }


    @GetMapping("/appointments/edit/{id}")
    public String showEditAppointmentForm(@PathVariable int id, Model model) {
        Optional<Appointments> appointment = appointmentService.findAppointmentById(id);
        if (appointment.isPresent()) {
            model.addAttribute("appointment", appointment.get());
            model.addAttribute("patients", patientService.getAllPatients());
            model.addAttribute("doctors", doctorService.getAllDoctors());
            return "editAppointmentPage";
        } else {
            return "redirect:/api/appointments";
        }
    }

    @PostMapping("/appointments/edit/{id}")
    public String updateAppointment(@PathVariable int id, @ModelAttribute Appointments appointment) {
        appointment.setId(id);
        appointment.setPatient(patientService.getPatientById(appointment.getPatient().getPatient_id()).orElse(null));
        appointment.setDoctor(doctorService.getDoctorById(appointment.getDoctor().getDoctor_id()).orElse(null));
        appointmentService.addAppointment(appointment);
        return "redirect:/api/appointments";
    }


    @PostMapping("/appointments/delete/{id}")
    public String deleteAppointment(@PathVariable int id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/api/appointments";
    }
}
