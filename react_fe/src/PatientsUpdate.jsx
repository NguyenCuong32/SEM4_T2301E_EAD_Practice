import axios from 'axios';
import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import Navbar from "./Navbar";

function PatientsUpdate() {

  const {id} = useParams();
  const naviagate = useNavigate();

  useEffect(() => {
    axios.get('http://localhost:8080/api/v1/patients/' + id)
    .then(res => {
      console.log(res)
      setValues({id: res.data.id, 
                 fullName: res.data.fullName, 
                 dateOfBirth: res.data.dateOfBirth, 
                 gender: res.data.gender, 
                 address: res.data.address, 
                 phoneNumber: res.data.phoneNumber,
                 email: res.data.email})
    })
    .catch(err => console.log(err))
  }, [])

  const [values, setValues] = useState({
    fullName: '',
    dateOfBirth: '',
    gender: '',
    address: '',
    phoneNumber: '',
    email: ''
  })
  const handleUpdate = (event) => {
    event.preventDefault();
    axios.put('http://localhost:8080/api/v1/patients/' + id, values)
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
            <h2 className='title'>Add Patient</h2>
            <div className="mb-2">
              <label>Name</label>
              <input type="text" placeholder='Enter Name' className="form-control" value={values.fullName}
              onChange={e => setValues({...values, fullName: e.target.value})}/>
            </div>
            <div className="mb-2">
              <label>DoB</label>
              <input type="date" placeholder="Enter Date of Birth" className="form-control" value={values.dateOfBirth}
              onChange={e => setValues({...values, dateOfBirth: e.target.value})}/>
            </div>
            <div className="mb-2">
              <label>Gender</label>
              <input type="text" placeholder='Enter Gender' className="form-control" value={values.gender}
              onChange={e => setValues({...values, gender: e.target.value})}/>
            </div>
            <div className="mb-2">
              <label>Address</label>
              <input type="text" placeholder='Enter Address' className="form-control" value={values.address}
              onChange={e => setValues({...values, address: e.target.value})}/>
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
            <button className="btn btn-success">Submit</button>
          </form>
        </div>
      </div>
    </div>
  )
}

export default PatientsUpdate