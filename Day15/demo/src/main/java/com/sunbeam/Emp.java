package com.sunbeam;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "add")
@Entity
@Table(name="emp")
public class Emp {
     
	@Id
	private int empno;
	private String ename;
	private String job;
	private Integer mgr;
	private Date hire;
	private double sal;
	private Integer comm;
	private int deptno;
	@OneToOne(mappedBy = "emp")
	private Address add;
}
