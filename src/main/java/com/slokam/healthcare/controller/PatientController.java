package com.slokam.healthcare.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.healthcare.entity.Patient;
import com.slokam.healthcare.patientsearchpojo.PatientSearchPojo;
import com.slokam.healthcare.repo.IPatientRepo;
import com.slokam.healthcare.service.IPatientService;
@RestController
@RequestMapping("patient")
public class PatientController {
	@Autowired
private IPatientService patientservice;
	

	
	@PostMapping("/register")
	public ResponseEntity<Patient>registerpatient(@RequestBody Patient patient){
		patientservice.patientRegistration(patient);
		return new ResponseEntity<Patient>(patient,HttpStatus.CREATED);
	}
		@PostMapping("/search")
		public ResponseEntity<List<Patient>> search(@RequestBody PatientSearchPojo pka){
			List<Patient>  li=patientservice.patientSearch(pka);
			return new ResponseEntity<List<Patient>>(li,HttpStatus.CREATED);
		}
		@GetMapping("/all")
		public ResponseEntity<List<Patient>>getAllPatient(){
			List<Patient>list=patientservice.getAllPatients();
			return ResponseEntity.ok(list);
			
		}@GetMapping("/byId/{id}")
		public ResponseEntity<Patient>getPatientById(@PathVariable Integer id){
			Patient patient=patientservice.getPatientById(id);
			return ResponseEntity.ok(patient);
			
		}@GetMapping("/evenlists")
		public ResponseEntity<List<Patient>> getAllEvenpatients(){
		List<Patient> li=patientservice.getAllPatients().stream().filter(patient->patient.getId()%2==0).collect(Collectors.toList());
			return ResponseEntity.ok(li);
			
		}@GetMapping("/allNames")
		public ResponseEntity<List<String>> allNames(){
       List<String>le= patientservice.getAllPatients().stream().map(patient->patient.getName()).collect(Collectors.toList());
		return ResponseEntity.ok(le);
	

	

}
}
		
	
