package com.banking.phieunoptiendao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.banking.dao.DAO;
import com.banking.dao.PhieuNopTienDAO;
import com.banking.entity.HopDongVay;
import com.banking.entity.PhieuNopTien;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPNopTienDAO extends DAO {

	@Test
	void test_Success_1() throws ClassNotFoundException, SQLException {
		boolean kqTest = true;

		PhieuNopTienDAO pntDAO = new PhieuNopTienDAO();

		connection.setAutoCommit(false);

		try {
			PhieuNopTien pnt = new PhieuNopTien();
			HopDongVay hdv = new HopDongVay();
			long millis = System.currentTimeMillis();
			Date now = new Date(millis);
			hdv.setID(10);
			pnt.setHopDongVay(hdv);
			pnt.setNgayDong(now);
			pnt.setTienLai((float) 2484.8398);
			pnt.setTienGoc((float) 13804.667);
			pnt.setTimeID(1);

			boolean kqDB = pntDAO.themPhieuNop(pnt);
			assertEquals(kqTest, kqDB);
		} finally {
			// TODO: handle finally clause
			connection.rollback();
		}
	}

	@Test
	void test_Success_2() throws ClassNotFoundException, SQLException {
		boolean kqTest = true;

		PhieuNopTienDAO pntDAO = new PhieuNopTienDAO();

		connection.setAutoCommit(false);

		try {
			PhieuNopTien pnt = new PhieuNopTien();
			HopDongVay hdv = new HopDongVay();
			long millis = System.currentTimeMillis();
			Date now = new Date(millis);
			hdv.setID(14);
			pnt.setHopDongVay(hdv);
			pnt.setNgayDong(now);
			pnt.setTienLai((float) 139.86);
			pnt.setTienGoc((float) 777.0);
			pnt.setTimeID(1);

			boolean kqDB = pntDAO.themPhieuNop(pnt);
			assertEquals(kqTest, kqDB);
		} finally {
			// TODO: handle finally clause
			connection.rollback();
		}
	}

	@Test
	void test_Fail_1() throws ClassNotFoundException, SQLException {
		boolean kqTest = false;

		PhieuNopTienDAO pntDAO = new PhieuNopTienDAO();

		connection.setAutoCommit(false);

		try {
			PhieuNopTien pnt = new PhieuNopTien();
			HopDongVay hdv = new HopDongVay();
			long millis = System.currentTimeMillis();
			Date now = new Date(millis);
			hdv.setID(28);
			pnt.setHopDongVay(hdv);
			pnt.setNgayDong(now);
			pnt.setTienLai((float) 2484.8398);
			pnt.setTienGoc((float) 13804.667);
			pnt.setTimeID(1);

			boolean kqDB = pntDAO.themPhieuNop(pnt);
			assertEquals(kqTest, kqDB);
		} finally {
			// TODO: handle finally clause
			connection.rollback();
		}
	}

	@Test
	void test_Fail_2() throws ClassNotFoundException, SQLException {
		boolean kqTest = false;

		PhieuNopTienDAO pntDAO = new PhieuNopTienDAO();

		connection.setAutoCommit(false);

		try {
			PhieuNopTien pnt = new PhieuNopTien();
			HopDongVay hdv = new HopDongVay();
			long millis = System.currentTimeMillis();
			Date now = new Date(millis);
			hdv.setID(29);
			pnt.setHopDongVay(hdv);
			pnt.setNgayDong(now);
			pnt.setTienLai((float) 2484.8398);
			pnt.setTienGoc((float) 13804.667);
			pnt.setTimeID(1);

			boolean kqDB = pntDAO.themPhieuNop(pnt);
			assertEquals(kqTest, kqDB);
		} finally {
			// TODO: handle finally clause
			connection.rollback();
		}
	}

}
