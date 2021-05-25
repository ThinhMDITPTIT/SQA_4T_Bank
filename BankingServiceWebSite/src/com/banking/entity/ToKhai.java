package com.banking.entity;

import java.sql.Timestamp;

public class ToKhai {
	private int ID, userID;
	private String Nghenghiep, Chucvu, Diachicongty, Tencongty, Mucluong, Chitieuhangthang;
	private Timestamp createdAt;

	public ToKhai() {
		super();
	}

	public ToKhai(int userID, String nghenghiep, String chucvu, String tencongty,String diachicongty, String mucluong,
			String chitieuhangthang) {
		super();
		this.userID = userID;
		this.Nghenghiep = nghenghiep;
		this.Chucvu = chucvu;
		this.Diachicongty = diachicongty;
		this.Tencongty = tencongty;
		this.Mucluong = mucluong;
		this.Chitieuhangthang = chitieuhangthang;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getNghenghiep() {
		return Nghenghiep;
	}

	public void setNghenghiep(String nghenghiep) {
		Nghenghiep = nghenghiep;
	}

	public String getChucvu() {
		return Chucvu;
	}

	public void setChucvu(String chucvu) {
		Chucvu = chucvu;
	}

	public String getDiachicongty() {
		return Diachicongty;
	}

	public void setDiachicongty(String diachicongty) {
		Diachicongty = diachicongty;
	}

	public String getTencongty() {
		return Tencongty;
	}

	public void setTencongty(String tencongty) {
		Tencongty = tencongty;
	}

	public String getMucluong() {
		return Mucluong;
	}

	public void setMucluong(String mucluong) {
		Mucluong = mucluong;
	}

	public String getChitieuhangthang() {
		return Chitieuhangthang;
	}

	public void setChitieuhangthang(String chitieuhangthang) {
		Chitieuhangthang = chitieuhangthang;
	}
}
