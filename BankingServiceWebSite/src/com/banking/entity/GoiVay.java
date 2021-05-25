package com.banking.entity;

public class GoiVay {
	private Integer ID;
	private String tenGoi;
	private float laiSuat;
	private LoaiGoiVay loaiGoiVay;

	@Override
	public String toString() {
		return "goiVay [ID=" + ID + ", tenGoi=" + tenGoi + ", laiSuat=" + laiSuat + ", loaiGoiVay=" + loaiGoiVay + "]";
	}

	public GoiVay() {
		super();
	}

	public GoiVay(Integer iD, String tenGoi, float laiSuat, com.banking.entity.LoaiGoiVay loaiGoiVay) {
		super();
		ID = iD;
		this.tenGoi = tenGoi;
		this.laiSuat = laiSuat;
		this.loaiGoiVay = loaiGoiVay;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getTenGoi() {
		return tenGoi;
	}

	public void setTenGoi(String tenGoi) {
		this.tenGoi = tenGoi;
	}

	public float getLaiSuat() {
		return laiSuat;
	}

	public void setLaiSuat(float laiSuat) {
		this.laiSuat = laiSuat;
	}

	public LoaiGoiVay getLoaiGoiVay() {
		return loaiGoiVay;
	}

	public void setLoaiGoiVay(LoaiGoiVay loaiGoiVay) {
		this.loaiGoiVay = loaiGoiVay;
	}

}
