package com.banking.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.banking.entity.Users;

public class UsersDAO extends DAO {

	public UsersDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Users> searchUsers(String name) {
		ArrayList<Users> kq = new ArrayList<Users>();
		String sql = "SELECT * from USER where hoten like ? AND `Role` like 'customer'";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Users u = new Users();
				u.setUserId(rs.getInt("id"));
				u.setEmail(rs.getString("email"));
				u.setFullName(rs.getString("hoten"));
				kq.add(u);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kq;
	}

	public Users searchUsersID(int id) {

		Users u = null;
		String sql = "SELECT * from USER where ID like ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, "%" + id + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new Users();
				u.setEmail(rs.getString("email"));
				u.setFullName(rs.getString("hoten"));
				u.setCccd(rs.getString("Cmnd"));
				u.setDob(rs.getString("Ngaysinh"));
				u.setAddress(rs.getString("Diachi"));
				u.setPhone(rs.getString("sdt"));
				return u;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	public ArrayList<Users> getInfoUser(int id) {
		ArrayList<Users> kq = new ArrayList<Users>();
		String sql = "SELECT * FROM user as U INNER JOIN hopdongvay as H WHERE H.ID LIKE ? AND U.ID=H.UserID";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, "%" + id + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Users u = new Users();
				u.setCccd(rs.getString("cmnd"));
				u.setAddress(rs.getString("diachi"));
				u.setPhone(rs.getString("sdt"));
				u.setEmail(rs.getString("email"));
				u.setFullName(rs.getString("hoten"));
				u.setPassword(rs.getString("password"));
				kq.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kq;
	}

	public boolean checkLogin(String username, String password) throws ClassNotFoundException, SQLException {
		boolean kq = false;
		String sql = "SELECT * FROM `user` WHERE Username = ? AND Password = ?";
		try (PreparedStatement pre = connection.prepareStatement(sql)) {
			pre.setString(1, username);
			pre.setString(2, password);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				kq = true;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return kq;
	}

	public boolean isAdmin(String username) throws ClassNotFoundException, SQLException {
		boolean isAdmin = false;
		String sql = "SELECT Role FROM `user` WHERE Username = ? AND Role = 'ADMIN' ";
		try (PreparedStatement pre = connection.prepareStatement(sql)) {
			pre.setString(1, username);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				isAdmin = true;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return isAdmin;
	}

	public boolean addCustomer(Users user) {
		boolean kq = false;
		String sql = "INSERT INTO " + "`user`(Hoten,Cmnd,Sdt,Email,Diachi,Ngaysinh,Role) " + "values (?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getFullName());
			ps.setString(2, user.getCccd());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getAddress());
			ps.setString(6, user.getDob());
			ps.setString(7, "customer");
			ps.executeUpdate();
			kq = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kq;
	}
}
