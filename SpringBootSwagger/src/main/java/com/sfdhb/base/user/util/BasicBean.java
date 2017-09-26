package com.sfdhb.base.user.util;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * hibernate 基类
 * @author pp
 * @date 2017年9月25日15:55:36
 *
 */
public class BasicBean implements Serializable{

	private static final long serialVersionUID = 1892428089787747552L;
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
