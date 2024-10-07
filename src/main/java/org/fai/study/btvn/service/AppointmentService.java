    package org.fai.study.btvn.service;

    import org.fai.study.btvn.entity.Appointment;
    import org.fai.study.btvn.entity.Doctor;
    import org.fai.study.btvn.entity.Patient;
    import org.fai.study.btvn.repository.IAppointmentRepository;
    import org.fai.study.btvn.repository.IDoctorRepository;
    import org.fai.study.btvn.repository.IPatientRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;

    import java.util.List;

    @Service
    public class AppointmentService implements IAppointmentService {
        @Autowired
        private IAppointmentRepository appointmentRepository;
        @Autowired
        private IDoctorRepository doctorRepository;
        @Autowired
        private IPatientRepository patientRepository;

        @Override
        public List<Appointment> getAppointments() {
            var appointments = appointmentRepository.findAll();
            return appointments;
        }
        @Override
        public Appointment getAppointmentbyId(int id){
            return appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("cant find Appointment"));
        }
        @Override
        public Appointment addAppointment(Appointment appointment){
            if (!patientRepository.existsById(appointment.getPatient().getPatient_id())) {
                throw new IllegalArgumentException("Patient does not exist.");
            }

            if (!doctorRepository.existsById(appointment.getDoctor().getDoctor_id())) {
                throw new IllegalArgumentException("Doctor does not exist.");
            }
            return appointmentRepository.save(appointment);
        }
        @Override
        public Appointment updateAppointment(int appointmentId, Appointment appointment) {
            Appointment existingAppointment = appointmentRepository.findById(appointmentId)
                    .orElseThrow(() -> new IllegalArgumentException("Appointment not found."));
            existingAppointment.setAppointment_date(appointment.getAppointment_date());
            existingAppointment.setReason(appointment.getReason());
            existingAppointment.setStatus(appointment.getStatus());

            return appointmentRepository.save(existingAppointment);
        }

        @Override
        public void deleteAppointment(int appointmentId) {
            if (!appointmentRepository.existsById(appointmentId)) {
                throw new IllegalArgumentException("Appointment not found.");
            }
            appointmentRepository.deleteById(appointmentId);
        }
    }