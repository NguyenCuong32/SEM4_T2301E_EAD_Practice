import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import Navbar from './Navbar';

function Home() {
  const [data, setData] = useState([]);
  useEffect(() => {
    axios.get('http://localhost:8080/api/v1/appointments')
    .then(res => setData(res.data))
    .catch(err => console.log(err))
  }, [])

  const handleDelete = (id) => {
    axios.delete('http://localhost:8080/api/v1/appointments/' + id)
    .then(res => {
      location.reload();
    })
    .catch(err => console.log(err))
  }

  return (
    <div>
      <Navbar />
      <div className='d-flex vh-100 bg-primary justify-content-center align-items-center'>
        <div className='w-75 bg-white rounded p-3'>
          <h2>Appointment List</h2>
          <div className='d-flex justify-content-end'>
            <Link to='/create' className='btn btn-success'>Create +</Link>
          </div>
          <table className='table'>
            <thead>
              <tr>
                <th>ID</th>
                <th>Patient</th>
                <th>Doctor</th>
                <th>Date</th>
                <th>Reason</th>
                <th>Status</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {data.map((appointment, index) => {
                return <tr key={index}>
                  <td>{appointment.appointmentId}</td>
                  <td>{appointment.patient.fullName}</td>
                  <td>{appointment.doctor.fullName}</td>
                  <td>{appointment.appointmentDate}</td>
                  <td>{appointment.reason}</td>
                  <td>{appointment.status}</td>
                  <td>
                    <button onClick={() => handleDelete(appointment.appointmentId)} className='btn btn-sm btn-danger'>Delete</button>
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

export default Home