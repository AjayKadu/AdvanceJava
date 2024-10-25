package com.sunbeam;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="emp")
public class Employee {
     
	@Id @Column(name="empno")
	private int id;
	private String ename;
	private String job;
	private Integer mgr;
	private double sal;
	private Double comm;
	private int deptno;
	@Temporal(TemporalType.DATE)
	private Date hire;
	@Transient
	private Double income;
	
	public Employee() {
	
	}
	
	public Employee(int id, String ename, String job, Integer mgr, double sal, Double comm, int deptno, Date hire,
			Double income) {
		this.id = id;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
		this.hire = hire;
		this.income = income;
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

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
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
		return "Employee [id=" + id + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", sal=" + sal + ", comm="
				+ comm + ", deptno=" + deptno + ", hire=" + hire + ", income=" + income + "]";
	}
	
	
	
	
}
