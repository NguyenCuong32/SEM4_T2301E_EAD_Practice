create database medical_service;

use medical_service;

create table doctors
(
doctor_id int auto_increment
primary key,
full_name varchar(255) not null,
specialization varchar(100) not null,
phone_number varchar(15) null,
email varchar(100) null,
years_of_experience int null
);

create table patients
(
patient_id int auto_increment
primary key,
full_name varchar(255) not null,
date_of_birth date not null,
gender varchar(10) not null,
address varchar(255) null,
phone_number varchar(15) null,
email varchar(100) null
);

create table appointments
(
appointment_id int auto_increment
primary key,
patient_id int not null,
doctor_id int not null,
appointment_date datetime not null,
reason varchar(255) null,
status varchar(50) default 'pending' null,
constraint fk_doctor_id
foreign key (doctor_id) references doctors (doctor_id),
constraint fk_patient_id
foreign key (patient_id) references patients (patient_id)
);
