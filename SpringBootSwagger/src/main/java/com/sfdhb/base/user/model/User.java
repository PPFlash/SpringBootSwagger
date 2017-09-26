package com.sfdhb.base.user.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user") 
public class User implements Serializable {
	
	private static final long serialVersionUID = -1177026832326591471L;
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	@Column(name="username")
    private String userName="";
	@NotNull
	@Column(name="password")
	private String passWord="";
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
}
