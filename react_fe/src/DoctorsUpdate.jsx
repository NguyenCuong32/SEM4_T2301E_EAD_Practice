import axios from 'axios';
import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import Navbar from "./Navbar";

function DoctorsUpdate() {

  const {id} = useParams();
  const naviagate = useNavigate();

  useEffect(() => {
    axios.get('http://localhost:8080/api/v1/doctors/' + id)
    .then(res => {
      console.log(res)
      setValues({id: res.data.id, fullName: res.data.fullName, specialization: res.data.specialization, phoneNumber: res.data.phoneNumber, email: res.data.email, yearsOfExperience: res.data.yearsOfExperience})
    })
    .catch(err => console.log(err))
  }, [])

  const [values, setValues] = useState({
    fullName: '',
    specialization: '',
    phoneNumber: '',
    email: '',
    yearsOfExperience: ''
  })
  const handleUpdate = (event) => {
    event.preventDefault();
    axios.put('http://localhost:8080/api/v1/doctors/' + id, values)
    .then(res => {
      console.log(res);
      naviagate('/')
    }).catch(err => console.log(err));
  }
  return (
    <div>
      <Navbar />
      <div className='d-flex vh-100 bg-primary justify-content-center align-items-center'>
        <div className="w-50 bg-white rounded p-3">
          <form onSubmit={handleUpdate}>
            <h2 className='title'>Add Doctor</h2>
            <div className="mb-2">
              <label>Name</label>
              <input type="text" placeholder='Enter Name' className="form-control" value={values.fullName}
              onChange={e => setValues({...values, fullName: e.target.value})}/>
            </div>
            <div className="mb-2">
              <label>Specialization</label>
              <input type="text" placeholder='Enter Specialization' className="form-control" value={values.specialization}
              onChange={e => setValues({...values, specialization: e.target.value})}/>
            </div>
            <div className="mb-2">
              <label>Phone</label>
              <input type="text" placeholder='Enter Phone' className="form-control" value={values.phoneNumber}
              onChange={e => setValues({...values, phoneNumber: e.target.value})}/>
            </div>
            <div className="mb-2">
              <label>Email</label>
              <input type="email" placeholder="Enter Email" className="form-control" value={values.email}
              onChange={e => setValues({...values, email: e.target.value})}/>
            </div>
            <div className="mb-2">
              <label>Years of Experience</label>
              <input type="number" placeholder="Enter YoE" className="form-control" value={values.yearsOfExperience}
              onChange={e => setValues({...values, yearsOfExperience: parseInt(e.target.value)})}/>
            </div>
            <button className="btn btn-success">Submit</button>
          </form>
        </div>
      </div>
    </div>
  )
}

export default DoctorsUpdate