package com.sunbeam;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "meeting")
public class Meeting {
     
	@Id 
	private int id;
	private String subject;
	@Column(name="meetdate")
	private Date meetDate;
	
	@ManyToMany(mappedBy = "meetList")
	private List<Emp> empList;

	@Override
	public String toString() {
		return "Meeting [id=" + id + ", subject=" + subject + ", meetDate=" + meetDate + ", empList=" + empList + "]";
	}

	public List<Emp> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}

	public Meeting() {
	
	}

	public Meeting(int id, String subject, Date meetDate) {
		this.id = id;
		this.subject = subject;
		this.meetDate = meetDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getMeetDate() {
		return meetDate;
	}

	public void setMeetDate(Date meetDate) {
		this.meetDate = meetDate;
	}
	
	
}
