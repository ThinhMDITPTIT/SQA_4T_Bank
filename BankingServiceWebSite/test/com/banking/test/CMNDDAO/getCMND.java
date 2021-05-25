package com.banking.test.CMNDDAO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.banking.dao.CmndDAO;
import com.banking.entity.Cmnd;

class getCMND {

	@Test
	void test() {
		String soCmnd = "017351221";
		Cmnd cmndDataTest = new Cmnd();
		cmndDataTest.setSoCmnd(soCmnd);
		cmndDataTest.setNgaycap("2012-04-02");
		cmndDataTest.setNoiCap("Ha noi");
		cmndDataTest.setDCThuongTru("Thanh Xuan - Ha noi");
		Cmnd cmndFromDB = new Cmnd();
		CmndDAO cmndDAO = new CmndDAO();
		cmndFromDB = cmndDAO.getCmnd(soCmnd);
		assertEquals(cmndFromDB.getSoCmnd(), cmndDataTest.getSoCmnd());
		assertEquals(cmndFromDB.getDCThuongTru(), cmndDataTest.getDCThuongTru());
		assertEquals(cmndFromDB.getNgaycap(), cmndDataTest.getNgaycap());
		assertEquals(cmndFromDB.getNoiCap(), cmndDataTest.getNoiCap());
	}

	// get CMND object with SoCMND not exist
	@Test
	void test1() {
		String soCmnd = "01735122999";
		Cmnd cmndFromDB = new Cmnd();
		CmndDAO cmndDAO = new CmndDAO();
		cmndFromDB = cmndDAO.getCmnd(soCmnd);
		assertEquals(cmndFromDB, null);
	}

}
