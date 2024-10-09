import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';

/* Appointments */
import Home from './Home';
import Create from './Create';
//import Update from './Update';

/* Doctors */
import DoctorsDashboard from './DoctorsDashboard';
import DoctorsCreate from './DoctorsCreate';
import DoctorsUpdate from './DoctorsUpdate';

/* Patients */
import PatientsDashboard from './PatientsDashboard';
import PatientsCreate from './PatientsCreate';
import PatientsUpdate from './PatientsUpdate';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Home />}/>
        <Route path='/create' element={<Create />}/>

        <Route path='/doctors/' element={<DoctorsDashboard />}/>
        <Route path='/doctors/create' element={<DoctorsCreate />}/>
        <Route path='/doctors/edit/:id' element={<DoctorsUpdate />}/>

        <Route path='/patients/' element={<PatientsDashboard />}/>
        <Route path='/patients/create' element={<PatientsCreate />}/>
        <Route path='/patients/edit/:id' element={<PatientsUpdate />}/>
      </Routes>
    </BrowserRouter>
  )
}

export default App