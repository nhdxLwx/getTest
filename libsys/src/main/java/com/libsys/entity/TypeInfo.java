package com.libsys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "typeinfo")
public class TypeInfo {
	private int tno;		//类型编号
	private String tname;	//类型名称
	@Id
	@Column(name="tno")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	@Column(name = "tname")
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tname == null) ? 0 : tname.hashCode());
		result = prime * result + tno;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeInfo other = (TypeInfo) obj;
		if (tname == null) {
			if (other.tname != null)
				return false;
		} else if (!tname.equals(other.tname))
			return false;
		if (tno != other.tno)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TypeInfo [tno=" + tno + ", tname=" + tname + "]";
	}
	public TypeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeInfo(int tno, String tname) {
		super();
		this.tno = tno;
		this.tname = tname;
	}
	
}
