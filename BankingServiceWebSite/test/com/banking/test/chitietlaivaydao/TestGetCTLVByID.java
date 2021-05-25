package com.banking.test.chitietlaivaydao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.banking.dao.ChiTietLaiVayDAO;
import com.banking.entity.ChiTietLaiVay;

class TestGetCTLVByID {

	@Test
	void test_HaveThongTin_1() throws ClassNotFoundException, SQLException {
		int[] testHdvID = { 10, 14 };

		ArrayList<ChiTietLaiVay> ctlvTest = new ArrayList<ChiTietLaiVay>();
		ArrayList<ChiTietLaiVay> ctlvDB = new ArrayList<ChiTietLaiVay>();

		String[] tengoi = { "lai suat du no", "lai suat du no" };
		String[] loaigoi = { "vay tin chap", "vay tin chap" };
		float[] tienvay = { (float) 41414, (float) 2331 };
		float[] laisuat = { (float) 0.06, (float) 0.06 };
		String[] kihan = { "3 thang", "3 thang" };

		ChiTietLaiVayDAO ctlvDAO = new ChiTietLaiVayDAO();
		for (int i = 0; i < testHdvID.length; i++) {
			ChiTietLaiVay ctlv = new ChiTietLaiVay();
			ctlv.setTenGoi(tengoi[i]);
			ctlv.setLoaiGoi(loaigoi[i]);
			ctlv.setTienVay(tienvay[i]);
			ctlv.setLaiSuat(laisuat[i]);
			ctlv.setKiHan(kihan[i]);
			ctlvTest.add(ctlv);

			ctlvDB = ctlvDAO.getCTLVByID(testHdvID[i]);

			assertEquals(ctlvDB.get(0).getTenGoi(), ctlvTest.get(0).getTenGoi());
			assertEquals(ctlvDB.get(0).getLoaiGoi(), ctlvTest.get(0).getLoaiGoi());
			assertEquals(ctlvDB.get(0).getTienVay(), ctlvTest.get(0).getTienVay());
			assertEquals(ctlvDB.get(0).getLaiSuat(), ctlvTest.get(0).getLaiSuat());
			assertEquals(ctlvDB.get(0).getKiHan(), ctlvTest.get(0).getKiHan());

			ctlvTest.clear();
			ctlvDB.clear();
		}
	}

	@Test
	void test_HaveThongTin_2() throws ClassNotFoundException, SQLException {
		int[] testHdvID = { 22, 23 };

		ArrayList<ChiTietLaiVay> ctlvTest = new ArrayList<ChiTietLaiVay>();
		ArrayList<ChiTietLaiVay> ctlvDB = new ArrayList<ChiTietLaiVay>();

		String[] tengoi = { "lai suat du no", "lai suat co dinh" };
		String[] loaigoi = { "vay tin chap", "vay tin chap" };
		float[] tienvay = { (float) 22111, (float) 56677 };
		float[] laisuat = { (float) 0.06, (float) 0.08 };
		String[] kihan = { "6 thang", "3 thang" };

		ChiTietLaiVayDAO ctlvDAO = new ChiTietLaiVayDAO();
		for (int i = 0; i < testHdvID.length; i++) {
			ChiTietLaiVay ctlv = new ChiTietLaiVay();
			ctlv.setTenGoi(tengoi[i]);
			ctlv.setLoaiGoi(loaigoi[i]);
			ctlv.setTienVay(tienvay[i]);
			ctlv.setLaiSuat(laisuat[i]);
			ctlv.setKiHan(kihan[i]);
			ctlvTest.add(ctlv);

			ctlvDB = ctlvDAO.getCTLVByID(testHdvID[i]);

			assertEquals(ctlvDB.get(0).getTenGoi(), ctlvTest.get(0).getTenGoi());
			assertEquals(ctlvDB.get(0).getLoaiGoi(), ctlvTest.get(0).getLoaiGoi());
			assertEquals(ctlvDB.get(0).getTienVay(), ctlvTest.get(0).getTienVay());
			assertEquals(ctlvDB.get(0).getLaiSuat(), ctlvTest.get(0).getLaiSuat());
			assertEquals(ctlvDB.get(0).getKiHan(), ctlvTest.get(0).getKiHan());

			ctlvTest.clear();
			ctlvDB.clear();
		}
	}

	@Test
	void test_HaveThongTin_3() throws ClassNotFoundException, SQLException {
		int[] testHdvID = { 26, 27 };

		ArrayList<ChiTietLaiVay> ctlvTest = new ArrayList<ChiTietLaiVay>();
		ArrayList<ChiTietLaiVay> ctlvDB = new ArrayList<ChiTietLaiVay>();

		String[] tengoi = { "lai suat co dinh", "lai suat co dinh" };
		String[] loaigoi = { "vay tin chap", "vay tin chap" };
		float[] tienvay = { (float) 555, (float) 222 };
		float[] laisuat = { (float) 0.08, (float) 0.08 };
		String[] kihan = { "3 thang", "3 thang" };

		ChiTietLaiVayDAO ctlvDAO = new ChiTietLaiVayDAO();
		for (int i = 0; i < testHdvID.length; i++) {
			ChiTietLaiVay ctlv = new ChiTietLaiVay();
			ctlv.setTenGoi(tengoi[i]);
			ctlv.setLoaiGoi(loaigoi[i]);
			ctlv.setTienVay(tienvay[i]);
			ctlv.setLaiSuat(laisuat[i]);
			ctlv.setKiHan(kihan[i]);
			ctlvTest.add(ctlv);

			ctlvDB = ctlvDAO.getCTLVByID(testHdvID[i]);

			assertEquals(ctlvDB.get(0).getTenGoi(), ctlvTest.get(0).getTenGoi());
			assertEquals(ctlvDB.get(0).getLoaiGoi(), ctlvTest.get(0).getLoaiGoi());
			assertEquals(ctlvDB.get(0).getTienVay(), ctlvTest.get(0).getTienVay());
			assertEquals(ctlvDB.get(0).getLaiSuat(), ctlvTest.get(0).getLaiSuat());
			assertEquals(ctlvDB.get(0).getKiHan(), ctlvTest.get(0).getKiHan());

			ctlvTest.clear();
			ctlvDB.clear();
		}
	}

	@Test
	void test_NotHaveThongTin() throws ClassNotFoundException, SQLException {
		int[] testHdvID = { 30, 32 };

		ArrayList<ChiTietLaiVay> ctlvDB = new ArrayList<ChiTietLaiVay>();

		ChiTietLaiVayDAO ctlvDAO = new ChiTietLaiVayDAO();
		for (int i = 0; i < testHdvID.length; i++) {

			ctlvDB = ctlvDAO.getCTLVByID(testHdvID[i]);

			assertEquals(ctlvDB.size(), 0);
			ctlvDB.clear();
		}
	}

}
