package com.sunbeam;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="emp")
public class Employee {
     
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	//@ManyToOne
	@JoinColumn(name="deptno")
	private Dept dept;
	
	public Employee() {
	
	}

	public Employee(int id, String ename, String job, Integer mgr, double sal, Double comm, Date hire, Double income,
			Dept dept) {
		this.id = id;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.sal = sal;
		this.comm = comm;
		this.hire = hire;
		this.income = income;
		this.dept = dept;
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

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", sal=" + sal + ", comm="
				+ comm + ", hire=" + hire + ", income=" + income + ", dept=" + dept + "]";
	}
	
	
	
	
}
