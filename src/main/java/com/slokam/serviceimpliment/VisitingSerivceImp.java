package com.slokam.serviceimpliment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.healthcare.repo.VisitingRepo;
import com.slokam.healthcare.service.VesitingService;

@Service
public class VisitingSerivceImp implements VesitingService {
	
	@Autowired
	private VisitingRepo repo;

	@Override
	public List<Object[]> getVestingByPatientId(Integer id) {
		// TODO Auto-generated method stub
		return repo.getVisitingById1(id);
	}
	
	
	
	

}
