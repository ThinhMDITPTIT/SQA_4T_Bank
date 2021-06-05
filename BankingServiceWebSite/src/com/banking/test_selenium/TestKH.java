package com.banking.test_selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.banking.dao.CmndDAO;
import com.banking.dao.DAO;

public class TestKH extends TestDriver {
	ChromeDriver driver = getDriver();
	DAO dao = new DAO();
	Connection connection = DAO.getConnection();

//	@Test
//	public void log_in()  {
//		
//		driver.get("http://localhost:8080/BankingServiceWebSite/");
//		driver.findElement(By.id("log_in_button")).click();
//		driver.findElement(By.id("username")).sendKeys("thinhme99");
//		driver.findElement(By.id("password")).sendKeys("thinh12345");
//		driver.findElement(By.id("dologin")).click();
//		String title = driver.getTitle();
//		String expectedTitle = "Trang chủ";
//		assertEquals(title, expectedTitle);
//		driver.close();
//	}
//	@Test
//	public void log_in_fail()  {
//		
//		driver.get("http://localhost:8080/BankingServiceWebSite/");
//		driver.findElement(By.id("log_in_button")).click();
//		driver.findElement(By.id("username")).sendKeys("thinhme9");
//		driver.findElement(By.id("password")).sendKeys("thinh12345");
//		driver.findElement(By.id("dologin")).click();
//		String notifyMess = driver.switchTo().alert().getText();
//		System.out.println(notifyMess);
//		String expectedMes = "Username hoặc Password không chính xác";
//		assertEquals(notifyMess, expectedMes);
//		driver.switchTo().alert().accept();
//		
//		String title = driver.getTitle();
//		String expectedTitle = "Login";
//		assertEquals(title, expectedTitle);
//		driver.close();
//	}
	
	@Test
	public void themmoi_khachhang_success() throws SQLException {
		connection.setAutoCommit(false);
		try {
			driver.get("http://localhost:8080/BankingServiceWebSite/");
			driver.findElement(By.id("log_in_button")).click();
			driver.findElement(By.id("username")).sendKeys("thinhme99");
			driver.findElement(By.id("password")).sendKeys("thinh12345");
			driver.findElement(By.id("dologin")).click();
			driver.findElement(By.id("vay_lai_button")).click();
			driver.findElement(By.id("them_kh_button")).click();
			driver.findElement(By.id("hoten")).sendKeys("Truong Dinh Tien");
			driver.findElement(By.id("dob")).sendKeys("16/03/1997");
			driver.findElement(By.id("sdt")).sendKeys("0385676597");
			driver.findElement(By.id("cmnd")).sendKeys("017351213131111111");
			driver.findElement(By.id("ngaycap")).sendKeys("04/02/2012");
			driver.findElement(By.id("noicap")).sendKeys("Ha noi");
			driver.findElement(By.id("dcthuongtru")).sendKeys("Thanh Xuan nam - Ha noi");
			driver.findElement(By.id("dchientai")).sendKeys("495 Nguyen Trai - Thanh xuan - Ha noi");
			driver.findElement(By.id("email")).sendKeys("shadowking1603@gmail.com");
			driver.findElement(By.id("doAddUser")).click();
			
			String notifyMess = driver.switchTo().alert().getText();
			System.out.println(notifyMess);
			String expectedMes = "Thêm mới khách hàng thành công !";
			assertEquals(notifyMess, expectedMes);
			driver.switchTo().alert().accept();
			
			String title = driver.getTitle();
			String expectedTitle = "Tìm kiếm khách hàng";
			assertEquals(title, expectedTitle);
			
		}finally {
			connection.rollback();
			CmndDAO cmndDAO = new CmndDAO();
			cmndDAO.deleteCmnd("017351213131");
			connection.close();
			driver.close();
		}
	}
	
	@Test
	public void validateEmail() throws SQLException {
		try {
			driver.get("http://localhost:8080/BankingServiceWebSite/");
			driver.findElement(By.id("log_in_button")).click();
			driver.findElement(By.id("username")).sendKeys("thinhme99");
			driver.findElement(By.id("password")).sendKeys("thinh12345");
			driver.findElement(By.id("dologin")).click();
			driver.findElement(By.id("vay_lai_button")).click();
			driver.findElement(By.id("them_kh_button")).click();
			driver.findElement(By.id("hoten")).sendKeys("Truong Dinh Tien");
			driver.findElement(By.id("dob")).sendKeys("16/03/1997");
			driver.findElement(By.id("sdt")).sendKeys("0385676597");
			driver.findElement(By.id("cmnd")).sendKeys("017351213131111111");
			driver.findElement(By.id("ngaycap")).sendKeys("04/02/2012");
			driver.findElement(By.id("noicap")).sendKeys("Ha noi");
			driver.findElement(By.id("dcthuongtru")).sendKeys("Thanh Xuan nam - Ha noi");
			driver.findElement(By.id("dchientai")).sendKeys("495 Nguyen Trai - Thanh xuan - Ha noi");
			driver.findElement(By.id("email")).sendKeys("shadowking1603");
			driver.findElement(By.id("doAddUser")).click();
			
			String notifyMess = driver.switchTo().alert().getText();
			System.out.println(notifyMess);
			String expectedMes = "Email không đúng định dạng!!!";
			assertEquals(notifyMess, expectedMes);
			driver.switchTo().alert().accept();
			
			String title = driver.getTitle();
			String expectedTitle = "Thêm khách hàng";
			assertEquals(title, expectedTitle);
			
		}finally {
			driver.close();
		}
	}
	
//	@Test
//	public void huy_themmoi_khachhang_success() throws SQLException {
//		dao.connection.setAutoCommit(false);
//		try {
//			driver.get("http://localhost:8080/BankingServiceWebSite/");
//			driver.findElement(By.id("log_in_button")).click();
//			driver.findElement(By.id("username")).sendKeys("thinhme99");
//			driver.findElement(By.id("password")).sendKeys("thinh12345");
//			driver.findElement(By.id("dologin")).click();
//			driver.findElement(By.id("vay_lai_button")).click();
//			driver.findElement(By.id("them_kh_button")).click();
//			driver.findElement(By.id("hoten")).sendKeys("Truong Dinh Tien");
//			driver.findElement(By.id("dob")).sendKeys("16/03/1997");
//			driver.findElement(By.id("sdt")).sendKeys("0385676597");
//			driver.findElement(By.id("cmnd")).sendKeys("0173512111111");
//			driver.findElement(By.id("ngaycap")).sendKeys("04/02/2012");
//			driver.findElement(By.id("noicap")).sendKeys("Ha noi");
//			driver.findElement(By.id("dcthuongtru")).sendKeys("Thanh Xuan nam - Ha noi");
//			driver.findElement(By.id("dchientai")).sendKeys("495 Nguyen Trai - Thanh xuan - Ha noi");
//			driver.findElement(By.id("email")).sendKeys("shadowking1603@gmail.com");
//			driver.findElement(By.id("cancel_button")).click();
//			
//			
//			String title = driver.getTitle();
//			String expectedTitle = "Tìm kiếm khách hàng";
//			assertEquals(title, expectedTitle);
//			
//		}finally {
//			connection.rollback();
//			connection.close();
//			driver.close();
//		}
//	}
//
//	@Test
//	public void tim_kiem_khachhang() throws SQLException {
//		dao.connection.setAutoCommit(false);
//		try {
//			driver.get("http://localhost:8080/BankingServiceWebSite/");
//			driver.findElement(By.id("log_in_button")).click();
//			driver.findElement(By.id("username")).sendKeys("thinhme99");
//			driver.findElement(By.id("password")).sendKeys("thinh12345");
//			driver.findElement(By.id("dologin")).click();
//			driver.findElement(By.id("vay_lai_button")).click();
//			driver.findElement(By.id("name")).sendKeys("Ta Xuan Toan");
//			driver.findElement(By.id("tim_kiem_khach_hang")).click();
//			String tenKH = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
//			String expectedTenKH ="Ta Xuan Toan";
//			
//			assertEquals(tenKH, expectedTenKH);
//			
//			driver.close();
//		}finally {
//			connection.rollback();
//			//dao.connection.close();
//		}
//	}
//	@Test
//	public void kiem_tra_thongtinHK() throws SQLException {
//		dao.connection.setAutoCommit(false);
//		try {
//			driver.get("http://localhost:8080/BankingServiceWebSite/");
//			driver.findElement(By.id("log_in_button")).click();
//			driver.findElement(By.id("username")).sendKeys("thinhme99");
//			driver.findElement(By.id("password")).sendKeys("thinh12345");
//			driver.findElement(By.id("dologin")).click();
//			driver.findElement(By.id("vay_lai_button")).click();
//			driver.findElement(By.id("name")).sendKeys("t");
//			driver.findElement(By.id("tim_kiem_khach_hang")).click();
//			String tenKH = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
//			String expectedTenKH ="Ta Xuan Toan";
//			
//			if(tenKH == expectedTenKH) {
//				driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).click();
//				String SoCMND = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText();
//				String expectedSoCMND = "001088011195";
//				assertEquals(SoCMND, expectedSoCMND);
//				String noKhaiBaoText = driver.findElement(By.id("no_khaibao_text")).getText();
//				String expectedNoKBText = "Khách hàng chưa khai báo thông tin vay";
//				assertEquals(noKhaiBaoText, expectedNoKBText);
//			}
//			
//			driver.close();
//		}finally {
//			connection.rollback();
//			//dao.connection.close();
//		}
//	}
//
//
	@Test
	public void them_moi_khachhang_fail() throws SQLException {
		dao.connection.setAutoCommit(false);
		try {
			driver.get("http://localhost:8080/BankingServiceWebSite/");
			driver.findElement(By.id("log_in_button")).click();
			driver.findElement(By.id("username")).sendKeys("thinhme99");
			driver.findElement(By.id("password")).sendKeys("thinh12345");
			driver.findElement(By.id("dologin")).click();
			driver.findElement(By.id("vay_lai_button")).click();
			driver.findElement(By.id("them_kh_button")).click();
			driver.findElement(By.id("hoten")).sendKeys("Truong Dinh Tien");
			driver.findElement(By.id("dob")).sendKeys("16/03/1997");
			driver.findElement(By.id("sdt")).sendKeys("0385676597");
			driver.findElement(By.id("cmnd")).sendKeys("001099011185");
			driver.findElement(By.id("ngaycap")).sendKeys("04/02/2012");
			driver.findElement(By.id("noicap")).sendKeys("Ha noi");
			driver.findElement(By.id("dcthuongtru")).sendKeys("Thanh Xuan nam - Ha noi");
			driver.findElement(By.id("dchientai")).sendKeys("495 Nguyen Trai - Thanh xuan - Ha noi");
			driver.findElement(By.id("email")).sendKeys("shadowking1603@gmail.com");
			driver.findElement(By.id("doAddUser")).click();

			String notifyMess = driver.switchTo().alert().getText();
			String expectedMes = "Khách hàng đã tồn tại!!!";
			assertEquals(notifyMess, expectedMes);
			driver.switchTo().alert().accept();

			String title = driver.getTitle();
			String expectedTitle = "Thêm khách hàng";
			assertEquals(title, expectedTitle);

			driver.close();
		} finally {
			connection.rollback();
			 dao.connection.close();
		}
	}
	
}
