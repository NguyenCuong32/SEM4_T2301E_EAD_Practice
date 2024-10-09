import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "./Navbar";

function Appointment_Create() {
  const [values, setValues] = useState({
    appointmentDate: '',
    reason: '',
    status: '',
    doctorId: '',
    patientId: ''
  })
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post('http://localhost:8080/api/v1/appointments', values)
    .then(res => {
      console.log(res);
      navigate('/')
    })
    .catch(err => console.log(err))
    console.log(values);
  }
  return (
    <div>
      <Navbar />
      <div className='d-flex vh-100 bg-primary justify-content-center align-items-center'>
        <div className="w-50 bg-white rounded p-3">
          <form onSubmit={handleSubmit}>
            <h2 className='title'>Add Appointment</h2>
            <div className="mb-2">
              <label>PatientId</label>
              <input type="number" placeholder='Enter PatientId' className="form-control" 
              onChange={e => setValues({...values, patientId: parseInt(e.target.value)})}/>
            </div>
            <div className="mb-2">
              <label>DoctorId</label>
              <input type="number" placeholder='Enter PatientId' className="form-control" 
              onChange={e => setValues({...values, doctorId: parseInt(e.target.value)})}/>
            </div>
            <div className="mb-2">
              <label>Date</label>
              <input type="datetime-local" placeholder="Enter Appoinment Date" className="form-control"
              onChange={e => setValues({...values, appointmentDate: e.target.value})}/>
            </div>
            <div className="mb-2">
              <label>Reason</label>
              <input type="text" placeholder='Enter Reason' className="form-control" 
              onChange={e => setValues({...values, reason: e.target.value})}/>
            </div>
            <div className="mb-2">
              <label>Status</label>
              <input type="text" placeholder='Enter Status' className="form-control" 
              onChange={e => setValues({...values, status: e.target.value})}/>
            </div>
            <button className="btn btn-success">Submit</button>
          </form>
        </div>
      </div>
    </div>
  )
}

export default Appointment_Create