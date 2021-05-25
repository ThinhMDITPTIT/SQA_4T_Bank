package com.banking.entity;

import java.sql.Timestamp;

public class Cmnd {
	private String soCmnd;
	private String ngaycap;
	private String noiCap;
	private String dcThuongTru;

	public Cmnd() {

	}

	public Cmnd(String soCmnd, String ngaycap, String noiCap, String dcThuongTru) {
		super();
		this.soCmnd = soCmnd;
		this.ngaycap = ngaycap;
		this.noiCap = noiCap;
		this.dcThuongTru = dcThuongTru;
	}

	public String getSoCmnd() {
		return soCmnd;
	}

	public void setSoCmnd(String soCmnd) {
		this.soCmnd = soCmnd;
	}

	public String getNgaycap() {
		return ngaycap;
	}

	public void setNgaycap(String ngaycap) {
		this.ngaycap = ngaycap;
	}

	public String getNoiCap() {
		return noiCap;
	}

	public void setNoiCap(String noiCap) {
		this.noiCap = noiCap;
	}

	public String getDCThuongTru() {
		return dcThuongTru;
	}

	public void setDCThuongTru(String dcThuongTru) {
		this.dcThuongTru = dcThuongTru;
	}

}
