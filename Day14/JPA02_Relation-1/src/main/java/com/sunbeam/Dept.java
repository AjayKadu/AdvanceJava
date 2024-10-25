package com.sunbeam;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dept")
public class Dept {
    @Id
	@Column(name = "deptno")
	private int deptid; 
	private String dname;
	private String loc;
	@OneToMany(mappedBy = "dept")
	private List<Emp> list;
	
	public List<Emp> getList() {
		return list;
	}

	public void setList(List<Emp> list) {
		this.list = list;
	}

	public Dept() {
		
	}

	public Dept(int deptid, String dname, String loc) {
		this.deptid = deptid;
		this.dname = dname;
		this.loc = loc;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Dept [deptid=" + deptid + ", dname=" + dname + ", loc=" + loc + "]";
	}
	
	
	
}
