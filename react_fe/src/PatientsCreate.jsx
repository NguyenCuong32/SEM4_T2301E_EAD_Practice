import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "./Navbar";

function PatientsCreate() {
  const [values, setValues] = useState({
    fullName: '',
    dateOfBirth: '',
    gender: '',
    address: '',
    phoneNumber: '',
    email: ''
  })
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post('http://localhost:8080/api/v1/patients', values)
    .then(res => {
      console.log(res);
      navigate('/')
    })
    .catch(err => console.log(err))
  }
  return (
    <div>
      <Navbar />
      <div className='d-flex vh-100 bg-primary justify-content-center align-items-center'>
        <div className="w-50 bg-white rounded p-3">
          <form onSubmit={handleSubmit}>
            <h2 className='title'>Add Patient</h2>
            <div className="mb-2">
              <label>Name</label>
              <input type="text" placeholder='Enter Name' className="form-control" 
              onChange={e => setValues({...values, fullName: e.target.value})}/>
            </div>
            <div className="mb-2">
              <label>DoB</label>
              <input type="date" placeholder="Enter Date of Birth" className="form-control"
              onChange={e => setValues({...values, dateOfBirth: e.target.value})}/>
            </div>
            <div className="mb-2">
              <label>Gender</label>
              <input type="text" placeholder='Enter Gender' className="form-control" 
              onChange={e => setValues({...values, gender: e.target.value})}/>
            </div>
            <div className="mb-2">
              <label>Address</label>
              <input type="text" placeholder='Enter Address' className="form-control" 
              onChange={e => setValues({...values, address: e.target.value})}/>
            </div>
            <div className="mb-2">
              <label>Phone</label>
              <input type="text" placeholder='Enter Phone' className="form-control" 
              onChange={e => setValues({...values, phoneNumber: e.target.value})}/>
            </div>
            <div className="mb-2">
              <label>Email</label>
              <input type="email" placeholder="Enter Email" className="form-control"
              onChange={e => setValues({...values, email: e.target.value})}/>
            </div>
            <button className="btn btn-success">Submit</button>
          </form>
        </div>
      </div>
    </div>
  )
}

export default PatientsCreate