package com.banking.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.banking.entity.Cmnd;

public class CmndDAO extends DAO {

	public CmndDAO() {
	}

	public boolean addCmnd(Cmnd cmnd) throws ClassNotFoundException, SQLException {
		boolean kq = false;
		String sql = "INSERT INTO `cmnd`(SoCMND,ngaycap,noicap,DCthuongtru) VALUES (?,?,?,?);";
		try (PreparedStatement pre = connection.prepareStatement(sql)) {
			pre.setString(1, cmnd.getSoCmnd());
			pre.setString(2, cmnd.getNgaycap());
			pre.setString(3, cmnd.getNoiCap());
			pre.setString(4, cmnd.getDCThuongTru());
			pre.executeUpdate();
			kq = true;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return kq;
	}

	public Cmnd getCmnd(String SoCmnd) {
		Cmnd cmnd = null;
		String sql = "SELECT * FROM `cmnd` WHERE SoCMND = ? ;";
		try (PreparedStatement pre = connection.prepareStatement(sql)) {
			pre.setString(1, SoCmnd);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				cmnd = new Cmnd();
				cmnd.setSoCmnd(SoCmnd);
				cmnd.setNoiCap(rs.getString("noicap"));
				cmnd.setNgaycap(rs.getString("ngaycap"));
				cmnd.setDCThuongTru(rs.getString("DCthuongtru"));

			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return cmnd;
	}
}
