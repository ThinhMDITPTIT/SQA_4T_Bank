package com.banking.entity;

import javax.persistence.Entity;

@Entity
public class LoaiGoiVay {
	private Integer ID;
	private String ten;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

}
