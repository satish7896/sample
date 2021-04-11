package com.slokam.healthcare.service;

import java.util.List;

import com.slokam.healthcare.entity.Patient;
import com.slokam.healthcare.patientsearchpojo.PatientSearchPojo;

public interface IPatientService {
public void patientRegistration(Patient patient) ;
public List<Patient>patientSearch(PatientSearchPojo searchPojo);
public List<Patient> getAllPatients();
public  Patient getPatientById(Integer id);
public Patient getAllEvenpatients();
public Patient getAllNames();
	
}


