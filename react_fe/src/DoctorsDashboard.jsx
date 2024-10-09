import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import Navbar from "./Navbar";

function DoctorDashboard() {
  const [data, setData] = useState([]);
  useEffect(() => {
    axios.get('http://localhost:8080/api/v1/doctors')
    .then(res => setData(res.data))
    .catch(err => console.log(err))
  }, [])

  const handleDelete = (id) => {
    axios.delete('http://localhost:8080/api/v1/doctors/' + id)
    .then(res => {
      location.reload();
    })
    .catch(err => {console.log(err); alert('Cannot Delete! User has a Relationship with an appointment!')})
  }

  return (
    <div>
      <Navbar />
      <div className='d-flex vh-100 bg-primary justify-content-center align-items-center'>
        <div className='w-75 bg-white rounded p-3'>
          <h2>Doctors List</h2>
          <div className='d-flex justify-content-end'>
            <Link to='/create' className='btn btn-success'>Create +</Link>
          </div>
          <table className='table'>
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Specialization</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Year</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {data.map((doctor, index) => {
                return <tr key={index}>
                  <td>{doctor.doctorId}</td>
                  <td>{doctor.fullName}</td>
                  <td>{doctor.specialization}</td>
                  <td>{doctor.phoneNumber}</td>
                  <td>{doctor.email}</td>
                  <td>{doctor.yearsOfExperience}</td>
                  <td>
                    <Link to={`/doctors/edit/${doctor.doctorId}`} className='btn btn-sm btn-primary mx-2'>Edit</Link>
                    <button onClick={() => handleDelete(doctor.doctorId)} className='btn btn-sm btn-danger'>Delete</button>
                  </td>
                </tr>
              })}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  )
}

export default DoctorDashboard