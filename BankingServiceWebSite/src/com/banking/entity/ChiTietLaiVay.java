package com.banking.entity;

import java.sql.Date;

public class ChiTietLaiVay {
	private String tenGoi;
	private String loaiGoi;
	private float laiSuat;
	private Date ngayVay;
	private float tienVay;
	private String trangThai;
	private String kiHan;

	public ChiTietLaiVay() {
		super();
	}

	public ChiTietLaiVay(String tenGoi, String loaiGoi, float laiSuat, Date ngayVay, float tienVay, String trangThai,
			String kiHan) {
		super();
		this.tenGoi = tenGoi;
		this.loaiGoi = loaiGoi;
		this.laiSuat = laiSuat;
		this.ngayVay = ngayVay;
		this.tienVay = tienVay;
		this.trangThai = trangThai;
		this.kiHan = kiHan;
	}

	public String getTenGoi() {
		return tenGoi;
	}

	public void setTenGoi(String tenGoi) {
		this.tenGoi = tenGoi;
	}

	public String getLoaiGoi() {
		return loaiGoi;
	}

	public void setLoaiGoi(String loaiGoi) {
		this.loaiGoi = loaiGoi;
	}

	public float getLaiSuat() {
		return laiSuat;
	}

	public void setLaiSuat(float laiSuat) {
		this.laiSuat = laiSuat;
	}

	public Date getNgayVay() {
		return ngayVay;
	}

	public void setNgayVay(Date ngayVay) {
		this.ngayVay = ngayVay;
	}

	public float getTienVay() {
		return tienVay;
	}

	public void setTienVay(float tienVay) {
		this.tienVay = tienVay;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getKiHan() {
		return kiHan;
	}

	public void setKiHan(String kiHan) {
		this.kiHan = kiHan;
	}

	@Override
	public String toString() {
		return "chitietLaiVay [tenGoi=" + tenGoi + ", loaiGoi=" + loaiGoi + ", laiSuat=" + laiSuat + ", ngayVay="
				+ ngayVay + ", tienVay=" + tienVay + ", trangThai=" + trangThai + ", kiHan=" + kiHan + "]";
	}
}
