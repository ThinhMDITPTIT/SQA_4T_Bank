
package com.banking.entity;

import java.sql.Date;

/**
 *
 * @author thuan
 */
public class HDVay {
	private int id, goivayID, userID, tokhaiID;
	private Date Ngayvay;
	private String Trangthai, kiHan;
	private float TienVay;

	public HDVay() {
	}

	public HDVay(int goivayID, int userID, Date Ngayvay, String kiHan, String Trangthai, float TienVay, int tokhaiID) {
		this.goivayID = goivayID;
		this.userID = userID;
		this.Ngayvay = Ngayvay;
		this.kiHan = kiHan;
		this.Trangthai = Trangthai;
		this.TienVay = TienVay;
		this.tokhaiID = tokhaiID;
	}

	public HDVay(int id, int goivayID, int userID, Date Ngayvay, String kiHan, String Trangthai, float TienVay,
			int tokhaiID) {
		this.id = id;
		this.goivayID = goivayID;
		this.userID = userID;
		this.Ngayvay = Ngayvay;
		this.kiHan = kiHan;
		this.Trangthai = Trangthai;
		this.TienVay = TienVay;
		this.tokhaiID = tokhaiID;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public int getGoivayID() {
		return goivayID;
	}

	public void setGoivayID(int goivayID) {
		this.goivayID = goivayID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Date getNgayvay() {
		return Ngayvay;
	}

	public void setNgayvay(Date Ngayvay) {
		this.Ngayvay = Ngayvay;
	}

	public String getkiHan() {
		return kiHan;
	}

	public void setkiHan(String kiHan) {
		this.kiHan = kiHan;
	}

	public String getTrangthai() {
		return Trangthai;
	}

	public void setTrangthai(String Trangthai) {
		this.Trangthai = Trangthai;
	}

	public double getTienVay() {
		return TienVay;
	}

	public void setTienVay(float TienVay) {
		this.TienVay = TienVay;
	}

	public int gettokhaiID() {
		return tokhaiID;
	}

	public void settokhaiID(int tokhaiID) {
		this.tokhaiID = tokhaiID;
	}

	@Override
	public String toString() {
		return "HDVay{" + "id=" + id + ", goivayID=" + goivayID + ", userID=" + userID + ", Ngayvay=" + Ngayvay
				+ ", kiHan=" + kiHan + ", Trangthai=" + Trangthai + ", TienVay=" + TienVay + ", tokhaiID=" + tokhaiID
				+ '}';
	}

}
