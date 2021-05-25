package com.banking.test.ToKhaiDAO;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.banking.dao.DAO;
import com.banking.dao.ToKhaiDAO;
import com.banking.entity.ToKhai;

class getToKhaiById extends DAO {

	@Test
	void test() throws SQLException {
		ToKhai tkDataTest = new ToKhai();
		tkDataTest.setID(1);
		tkDataTest.setNghenghiep("hoc sinh");
		tkDataTest.setChucvu("sinh vien");
		tkDataTest.setDiachicongty("thanh xuan");
		tkDataTest.setTencongty("PTIT");
		tkDataTest.setMucluong("1 trieu den 5 trieu");
		tkDataTest.setChitieuhangthang("1 Trieu den 5 trieu");
		int tkIDInputTest = 1;
		ToKhai tkFromDB = new ToKhai();
		ToKhaiDAO toKhaiDAO = new ToKhaiDAO();
		tkFromDB = toKhaiDAO.getTKByID(tkIDInputTest);
		assertEquals(tkFromDB.getID(), tkDataTest.getID());
		assertEquals(tkFromDB.getNghenghiep(), tkDataTest.getNghenghiep());
		assertEquals(tkFromDB.getChucvu(), tkDataTest.getChucvu());
		assertEquals(tkFromDB.getDiachicongty(), tkDataTest.getDiachicongty());
		assertEquals(tkFromDB.getTencongty(), tkDataTest.getTencongty());
		assertEquals(tkFromDB.getMucluong(), tkDataTest.getMucluong());
		assertEquals(tkFromDB.getChitieuhangthang(), tkDataTest.getChitieuhangthang());

	}

	// get a Tokhai isn`t exist
	@Test
	void test1() throws SQLException {

		int tkIDInputTest = 99;
		ToKhai tkFromDB = new ToKhai();
		ToKhaiDAO toKhaiDAO = new ToKhaiDAO();
		tkFromDB = toKhaiDAO.getTKByID(tkIDInputTest);
		assertEquals(tkFromDB, null);
	}
}
