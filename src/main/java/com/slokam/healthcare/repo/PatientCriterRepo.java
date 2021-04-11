package com.slokam.healthcare.repo;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.slokam.healthcare.entity.Patient;
import com.slokam.healthcare.patientsearchpojo.PatientSearchPojo;
import com.slokam.healthcare.utility.SearchUtility;

import antlr.StringUtils;

@Repository
public class PatientCriterRepo {
	//private static final Class Patient = null;
	@Autowired
	
	 private  EntityManager em;

public List<Patient> patientFullSearch(PatientSearchPojo searchPojo){
	CriteriaBuilder cb=em.getCriteriaBuilder();
	CriteriaQuery<Patient> cq=cb.createQuery(Patient.class);
	Root<Patient> r=cq.from(Patient.class);
	List<Predicate>predicatelist=new ArrayList<>();
	if (searchPojo !=null) {
		
		if (SearchUtility.serch(searchPojo.getName())) {
			//List<com.slokam.healthcare.entity.Patient> root;
			predicatelist.add(cb.like(r.get("name"),searchPojo.getName()+"%"));
			
		}
		if (searchPojo.getPhone() != null) {
			
			predicatelist.add(cb.equal(r.get("phone"),searchPojo.getPhone()));
		}
		if (searchPojo.getFromdate()!=null) {
		predicatelist.add(cb.greaterThanOrEqualTo(r.get("regDate"),searchPojo.getFromdate()));
		}
		if (searchPojo.getTodate()!=null) {
			predicatelist.add(cb.lessThanOrEqualTo(r.get("regDate"),searchPojo.getTodate()));
		}
		if (searchPojo.getStartintage()!=null) {
			predicatelist.add(cb.greaterThanOrEqualTo(r.get("age"),searchPojo.getStartintage()));
			
		}
		if (searchPojo.getEndage()!=null) {
			predicatelist.add(cb.le(r.get("age"),searchPojo.getEndage()));
		}
	
		
	}
	cq.where(predicatelist.toArray(new Predicate[predicatelist.size()]));
	
	TypedQuery<Patient> ty=em.createQuery(cq);
	
	 return ty.getResultList();

}}

