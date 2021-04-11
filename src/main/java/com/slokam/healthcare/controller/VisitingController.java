package com.slokam.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.serviceimpliment.VisitingSerivceImp;
@RestController
@RequestMapping("visiting")
public class VisitingController {
	@Autowired
	private VisitingSerivceImp VisitingService;
	@GetMapping("byid/{id}")
	public ResponseEntity<List<Object[]>> getVisitingByPatientId(@PathVariable Integer id){
		return ResponseEntity.ok(VisitingService.getVestingByPatientId(id));
	}
	

}
