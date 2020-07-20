package com.libsys.entity;

import javax.persistence.*;


@Entity
@Table(name = "admininfo")
public class AdminInfo {
	
	private int ano;		//id

	
	private String aname;	//账号
	
	private String pwd;		//密码
	
	private String power;	//权限
	@Override
	public String toString() {
		return "AdminInfo [ano=" + ano + ", aname=" + aname + ", pwd=" + pwd + ", power=" + power + "]";
	}
	public AdminInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminInfo(int ano, String aname, String pwd, String power) {
		super();
		this.ano = ano;
		this.aname = aname;
		this.pwd = pwd;
		this.power = power;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aname == null) ? 0 : aname.hashCode());
		result = prime * result + ano;
		result = prime * result + ((power == null) ? 0 : power.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
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
		AdminInfo other = (AdminInfo) obj;
		if (aname == null) {
			if (other.aname != null)
				return false;
		} else if (!aname.equals(other.aname))
			return false;
		if (ano != other.ano)
			return false;
		if (power == null) {
			if (other.power != null)
				return false;
		} else if (!power.equals(other.power))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		return true;
	}

	@Id
	@Column(name="ano")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}

	@Column(name = "aname")
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}

	@Column(name = "pwd")
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Column(name = "power")
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
}
