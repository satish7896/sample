package com.slokam.healthcare.patientsearchpojo;

import java.util.Date;

public class PatientSearchPojo {
private String name;
private Long phone;
private Date fromdate;
private Date todate;
private Integer pageno;
private Integer pagesize;
private Integer startintage;
private Integer endage;
private Integer gender;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Long getPhone() {
	return phone;
}
public void setPhone(Long phone) {
	this.phone = phone;
}
public Date getFromdate() {
	return fromdate;
}
public void setFromdate(Date fromdate) {
	this.fromdate = fromdate;
}
public Date getTodate() {
	return todate;
}
public void setTodate(Date todate) {
	this.todate = todate;
}
public Integer getPageno() {
	return pageno;
}
public void setPageno(Integer pageno) {
	this.pageno = pageno;
}
public Integer getPagesize() {
	return pagesize;
}
public void setPagesize(Integer pagesize) {
	this.pagesize = pagesize;
}
public Integer getStartintage() {
	return startintage;
}
public void setStartintage(Integer startintage) {
	this.startintage = startintage;
}
public Integer getEndage() {
	return endage;
}
public void setEndage(Integer endage) {
	this.endage = endage;
}
public Integer getGender() {
	return gender;
}
public void setGender(Integer gender) {
	this.gender = gender;
}
}
