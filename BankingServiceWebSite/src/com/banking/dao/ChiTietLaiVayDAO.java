package com.banking.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.banking.entity.ChiTietLaiVay;

public class ChiTietLaiVayDAO extends DAO {

	public ChiTietLaiVayDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<ChiTietLaiVay> getCTLVByID(int id) {
		ArrayList<ChiTietLaiVay> kq = new ArrayList<ChiTietLaiVay>();
		String sql = "SELECT * FROM goivay AS gv INNER JOIN loaigoivay AS lgv INNER JOIN hopdongvay AS hdv where hdv.ID = ? "
				+ "AND gv.ID = hdv.goivayID AND lgv.ID = gv.loaigoivayID";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ChiTietLaiVay ctlv = new ChiTietLaiVay();
				ctlv.setTenGoi(rs.getString("tengoi"));
				ctlv.setLoaiGoi(rs.getString("ten"));
				ctlv.setNgayVay(rs.getDate("ngayvay"));
				ctlv.setTienVay(rs.getFloat("tienvay"));
				ctlv.setLaiSuat(rs.getFloat("laisuat"));
				ctlv.setTrangThai(rs.getString("trangthai"));
				ctlv.setKiHan(rs.getString("kihan"));
				kq.add(ctlv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kq;
	}
}
