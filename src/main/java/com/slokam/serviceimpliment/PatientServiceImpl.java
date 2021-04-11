package com.slokam.serviceimpliment;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.OptBoolean;
import com.slokam.healthcare.entity.Patient;
import com.slokam.healthcare.patientsearchpojo.PatientSearchPojo;
import com.slokam.healthcare.repo.IPatientRepo;
import com.slokam.healthcare.repo.PatientCriterRepo;
import com.slokam.healthcare.service.IPatientService;
@Service
public class PatientServiceImpl implements IPatientService{
	@Autowired
	private IPatientRepo patientRepo;
	@Autowired
	private PatientCriterRepo patientCritr;

	@Override
	public void patientRegistration(Patient patient) {
		patient.setDate(new Date());
		patientRepo.save(patient);
		
	}

	@Override
	public List<Patient> patientSearch(PatientSearchPojo searchPojo) {
	
		return patientCritr.patientFullSearch(searchPojo);
		
	}

	@Override
	public List<Patient> getAllPatients() {
		
		return patientRepo.findAll();
	}

	@Override
	public Patient getPatientById(Integer id) {
		Optional<Patient>Patientopt =patientRepo.findById(id);
		if (Patientopt.isPresent()) {
			return Patientopt.get();
		}
		return null;
	}

	@Override
	public Patient getAllEvenpatients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient getAllNames() {
		// TODO Auto-generated method stub
		return null;
	}
	


}
