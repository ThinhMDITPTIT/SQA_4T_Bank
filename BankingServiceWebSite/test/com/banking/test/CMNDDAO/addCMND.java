package com.banking.test.CMNDDAO;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.banking.dao.CmndDAO;
import com.banking.dao.DAO;
import com.banking.entity.Cmnd;

class addCMND extends DAO {

	@Test
	void test() throws SQLException, ClassNotFoundException {

		boolean resultTest = true;

		Cmnd cmnd = new Cmnd();
		cmnd.setSoCmnd("017359999");
		cmnd.setNgaycap("2012-04-02");
		cmnd.setNoiCap("CATP.Ha noi");
		cmnd.setDCThuongTru("Thanh xuan - Ha noi");
		CmndDAO cmndDAO = new CmndDAO();
		boolean result = cmndDAO.addCmnd(cmnd);
		assertEquals(result, resultTest);
	}

	// add CMND is existed
	@Test
	void test1() throws SQLException, ClassNotFoundException {

		boolean resultTest = false;
		Cmnd cmnd = new Cmnd();
		cmnd.setSoCmnd("001099011185");
		cmnd.setNgaycap("2012-04-02");
		cmnd.setNoiCap("CATP.Ha noi");
		cmnd.setDCThuongTru("Thanh xuan - Ha noi");
		CmndDAO cmndDAO = new CmndDAO();
		boolean result = cmndDAO.addCmnd(cmnd);
		assertEquals(result, resultTest);
	}
}
