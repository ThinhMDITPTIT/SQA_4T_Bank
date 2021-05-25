/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banking.dao;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.banking.entity.HDVay;

/**
 *
 * @author thuan
 */
public class HDVaydao extends DAO {
	public HDVaydao() {
		super();
	}

	public ArrayList<HDVay> getHDVays() {
		ArrayList<HDVay> list = null;
		String sql = "select * from hopdongvay";
		CallableStatement cs;
		try {
			cs = connection.prepareCall(sql);
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				if (list == null)
					list = new ArrayList<>();
				list.add(new HDVay(rs.getInt(rs.findColumn("id")), rs.getInt(rs.findColumn("goivayID")),
						rs.getInt(rs.findColumn("userID")), rs.getDate(rs.findColumn("Ngayvay")),
						rs.getString(rs.findColumn("kiHan")), rs.getString(rs.findColumn("Trangthai")),
						rs.getFloat(rs.findColumn("TienVay")), rs.getInt(rs.findColumn("tokhaiID"))));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			list = null;
		}
		return list;
	}

	public HDVay getHDVaybyID(String id) {

		String sql = "SELECT * FROM sqa.hopdongvay where ID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new HDVay(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getString(5),
						rs.getString(6), rs.getFloat(7), rs.getInt(8));

			}
		} catch (SQLException e) {
		}
		return null;
	}

	public void suaHD(int id, int hgoivayid, int huserid, Date hngayvay, String hkihan, String htrangthai,
			float htienvay, int htokhaiid) {
		String sql = "UPDATE `sqa`.`hopdongvay`SET `goivayID` = ?,`userID` = ?,`Ngayvay` = ?,`kiHan` = ?,`Trangthai` = ?,`TienVay` = ?,`tokhaiID` = ? WHERE `ID` = ?;";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, hgoivayid);
			ps.setInt(2, huserid);
			ps.setDate(3, hngayvay);
			ps.setString(4, hkihan);
			ps.setString(5, htrangthai);
			ps.setFloat(6, htienvay);
			ps.setInt(7, htokhaiid);
			ps.setInt(8, id);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public void xoa(String id) {
		String sql = "DELETE FROM `sqa`.`hopdongvay`WHERE `ID` = ?;";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void them(int hgoivayid, int huserid, Date hngayvay, String hkihan, String htrangthai, float htienvay,
			int htokhaiid) {
		String sql = "INSERT INTO `sqa`.`hopdongvay`(`goivayID`,`userID`,`Ngayvay`,`kiHan`,`Trangthai`,`TienVay`,`tokhaiID`)VALUES(?,?,?,?,?,?,?);";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, hgoivayid);
			ps.setInt(2, huserid);
			ps.setDate(3, hngayvay);
			ps.setString(4, hkihan);
			ps.setString(5, htrangthai);
			ps.setFloat(6, htienvay);
			ps.setInt(7, htokhaiid);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public ArrayList<HDVay> searchHDVayByTKId(int tokhaiID, int userID) {
		ArrayList<HDVay> hdVayList = new ArrayList<HDVay>();
		String sql = "SELECT * from `sqa`.`hopdongvay` " + "where tokhaiID = ? and userID = ? ";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, tokhaiID);
			ps.setInt(2, userID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				HDVay hdVay = new HDVay();
				hdVay.setid(rs.getInt("ID"));
				hdVay.setGoivayID(rs.getInt("goivayID"));
				hdVay.setUserID(rs.getInt("userID"));
				hdVay.setNgayvay(rs.getDate("Ngayvay"));
				hdVay.setkiHan(rs.getString("kiHan"));
				hdVay.setTrangthai(rs.getString("Trangthai"));
				hdVay.setTienVay(rs.getFloat("TienVay"));
				hdVay.settokhaiID(rs.getInt("tokhaiID"));
				hdVayList.add(hdVay);

			}
		} catch (Exception e) {
		}
		return hdVayList;
	}
}
