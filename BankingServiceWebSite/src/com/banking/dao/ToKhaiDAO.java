package com.banking.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.banking.entity.ToKhai;
import com.banking.entity.Users;

public class ToKhaiDAO extends DAO {
	public ToKhaiDAO() {
		super();
	}

	public boolean addTokhai(ToKhai tokhaiobj) throws ClassNotFoundException, SQLException {
		boolean kq = false;
		System.out.println(tokhaiobj.getChucvu());
		String sql = "INSERT INTO `tokhai`(`userID`,`Nghenghiep`,`Chucvu`,`Tencongty` ,`Diachicongty`,`Mucluong`,`Chitieuhangthang`) VALUES (?,?,?,?,?,?,?);";
		try (PreparedStatement pre = connection.prepareStatement(sql)) {
			pre.setInt(1, tokhaiobj.getUserID());
			pre.setString(2, tokhaiobj.getNghenghiep());
			pre.setString(3, tokhaiobj.getChucvu());
			pre.setString(5, tokhaiobj.getDiachicongty());
			pre.setString(4, tokhaiobj.getTencongty());
			pre.setString(6, tokhaiobj.getMucluong());
			pre.setString(7, tokhaiobj.getChitieuhangthang());
			pre.executeUpdate();
			kq = true;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return kq;
	}

	public ArrayList<ToKhai> getAllToKhai(int customerID) {
		ArrayList<ToKhai> tokhai = new ArrayList<ToKhai>();
		String sql = "SELECT * FROM `tokhai`  WHERE userID = ? AND enable = 1 ;";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, customerID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ToKhai tk = new ToKhai();
				tk.setID(rs.getInt("ID"));
				tk.setNghenghiep(rs.getString("Nghenghiep"));
				tk.setChucvu(rs.getString("Chucvu"));
				tk.setDiachicongty(rs.getString("Diachicongty"));
				tk.setTencongty(rs.getString("Tencongty"));
				tk.setMucluong(rs.getString("Mucluong"));
				tk.setChitieuhangthang(rs.getString("Chitieuhangthang"));
				tk.setCreatedAt(rs.getTimestamp("createdAt"));
				tokhai.add(tk);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tokhai;
	}

	public boolean deleteToKhai(int tkID) {
		boolean kq = false;
		String sql = "UPDATE `tokhai` SET enable = ? WHERE ID = ?";
		try (PreparedStatement pre = connection.prepareStatement(sql)) {
			pre.setBoolean(1, false);
			pre.setInt(2, tkID);
			int rs= pre.executeUpdate();
			System.out.println(rs);
			if(rs == 1) {
				kq = true;
			}
			else {
				kq = false;
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return kq;
	}

	public ToKhai getTKByID(int tkID) {
		ToKhai tokhai = null;
		String sql = "SELECT * FROM `tokhai` WHERE ID =? ;";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, tkID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tokhai = new ToKhai();
				tokhai.setID(rs.getInt("ID"));
				tokhai.setNghenghiep(rs.getString("Nghenghiep"));
				tokhai.setChucvu(rs.getString("Chucvu"));
				tokhai.setDiachicongty(rs.getString("Diachicongty"));
				tokhai.setTencongty(rs.getString("Tencongty"));
				tokhai.setMucluong(rs.getString("Mucluong"));
				tokhai.setChitieuhangthang(rs.getString("Chitieuhangthang"));
				tokhai.setCreatedAt(rs.getTimestamp("createdAt"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tokhai;
	}

	public boolean updateToKhai(ToKhai tk) {
		boolean kq = false;
		String sql = "UPDATE `tokhai` SET `Nghenghiep` = ?," + "`Chucvu` = ?," + "`Diachicongty` =?,"
				+ "`Tencongty` =?," + "`Mucluong` = ?," + "`Chitieuhangthang`=?" + "  WHERE ID = ?;";
		try (PreparedStatement pre = connection.prepareStatement(sql)) {
			pre.setString(1, tk.getNghenghiep());
			pre.setString(2, tk.getChucvu());
			pre.setString(3, tk.getDiachicongty());
			pre.setString(4, tk.getTencongty());
			pre.setString(5, tk.getMucluong());
			pre.setString(6, tk.getChitieuhangthang());
			pre.setInt(7, tk.getID());
			int rs = pre.executeUpdate();
			if(rs == 1){
				kq = true;
			}
			kq =false;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return kq;
	}
}
