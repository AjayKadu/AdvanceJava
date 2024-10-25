package com.sunbeam;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "emp")
public class Emp {
	
    @Id
	@Column(name="empno")
	private int id;
	private String ename;
	private String job;
	private Integer mgr;
	private double sal;
	private Double comm;
	@Temporal(TemporalType.DATE)
	private Date hire;
	@Transient
	private Double income;
	
	@ManyToMany
	@JoinTable(name = "empmeeting", 
	joinColumns = @JoinColumn(name="empid"),
	inverseJoinColumns = @JoinColumn(name="meetingid"))
	private List<Meeting> meetList;
	
	public List<Meeting> getMeetList() {
		return meetList;
	}

	public void setMeetList(List<Meeting> meetList) {
		this.meetList = meetList;
	}

	public Emp() {
	
	}

	public Emp(int id, String ename, String job, Integer mgr, double sal, Double comm, Date hire, Double income,
			List<Meeting> meetList) {
		this.id = id;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.sal = sal;
		this.comm = comm;
		this.hire = hire;
		this.income = income;
		this.meetList = meetList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getMgr() {
		return mgr;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public Double getComm() {
		return comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

	public Date getHire() {
		return hire;
	}

	public void setHire(Date hire) {
		this.hire = hire;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	

	@Override
	public String toString() {
		return "Emp [id=" + id + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", sal=" + sal + ", comm="
				+ comm + ", hire=" + hire + ", income=" + income + "]";
	}

	
	
	
}
