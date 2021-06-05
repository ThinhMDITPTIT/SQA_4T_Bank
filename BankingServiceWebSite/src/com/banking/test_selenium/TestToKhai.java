package com.banking.test_selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.banking.dao.DAO;

public class TestToKhai extends TestDriver {
	ChromeDriver driver = getDriver();
	DAO dao = new DAO();
	Connection connection = DAO.getConnection();
	
	@Test
	public void addKhaibao() throws SQLException {
		dao.connection.setAutoCommit(false);
		try {
			driver.get("http://localhost:8080/BankingServiceWebSite/");
			driver.findElement(By.id("log_in_button")).click();
			driver.findElement(By.id("username")).sendKeys("thinhme99");
			driver.findElement(By.id("password")).sendKeys("thinh12345");
			driver.findElement(By.id("dologin")).click();
			driver.findElement(By.id("vay_lai_button")).click();
			driver.findElement(By.id("name")).sendKeys("t");
			driver.findElement(By.id("tim_kiem_khach_hang")).click();
			String tenKH = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
			String expectedTenKH ="Ta Xuan Toan";
			
			if(tenKH == expectedTenKH) {
				driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).click();
				String SoCMND = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText();
				String expectedSoCMND = "001088011195";
				assertEquals(SoCMND, expectedSoCMND);
				if(SoCMND == expectedSoCMND) {
					driver.findElement(By.id("them_khachhang_button")).click();
					driver.findElement(By.id("Nghenghiep")).sendKeys("Hoc Sinh");
					driver.findElement(By.id("Chucvu")).sendKeys("Sinh Vien");
					driver.findElement(By.id("Tencongty")).sendKeys("PTIT");
					driver.findElement(By.id("Diachicongty")).sendKeys("Tran Phu - Ha Dong");
					driver.findElement(By.id("mucluong2")).click();
					driver.findElement(By.id("Chitieuhangthang1")).click();
					driver.findElement(By.id("add_tk_button")).click();
					String notifyMess = driver.switchTo().alert().getText();
					System.out.println(notifyMess);
					String expectedMes = "Thêm tờ khai thành Công!!!";
					assertEquals(notifyMess, expectedMes);
					driver.switchTo().alert().accept();
					String title = driver.getTitle();
					String expectedTitle = "Danh sách Tờ Khai";
					assertEquals(title, expectedTitle);
				}
			}
			driver.close();
		}finally {
			dao.connection.rollback();
			//dao.connection.close();
		}
	}
	@Test
	public void kiem_tra_thongtinKhaiBao() throws SQLException {
		dao.connection.setAutoCommit(false);
		try {
			driver.get("http://localhost:8080/BankingServiceWebSite/");
			driver.findElement(By.id("log_in_button")).click();
			driver.findElement(By.id("username")).sendKeys("thinhme99");
			driver.findElement(By.id("password")).sendKeys("thinh12345");
			driver.findElement(By.id("dologin")).click();
			driver.findElement(By.id("vay_lai_button")).click();
			driver.findElement(By.id("name")).sendKeys("t");
			driver.findElement(By.id("tim_kiem_khach_hang")).click();
			String tenKH = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
			String expectedTenKH = "Ta Xuan Toan";

			driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).click();
			String SoCMND = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText();
			String expectedSoCMND = "001088011195";
			assertEquals(SoCMND, expectedSoCMND);
			String nghenghiep = driver.findElement(By.xpath("//table[2]/tbody[1]/tr[2]/td[2]")).getText();
			String expectedNN = "hoc sinh";
			assertEquals(expectedNN, nghenghiep);
			driver.findElement(By.xpath("//table[2]/tbody[1]/tr[1]/td[11]")).click();
			String title = driver.getTitle();
			String expectedTitle = "Vay Lãi";
			assertEquals(title, expectedTitle);
			String tenKHInVayLai = driver.findElement(By.xpath("//table[1]/tbody/tr[1]/td[1]")).getText();
			assertEquals(expectedTenKH, tenKHInVayLai);
			String ngheNghiepInVayLai = driver.findElement(By.xpath("//table[2]/tbody/tr[1]/td[1]")).getText();
			assertEquals(expectedNN, ngheNghiepInVayLai);

			driver.close();
		} finally {
			dao.connection.rollback();
			dao.connection.close();
		}
	}
	
	@Test
	public void sua_thongtinKhaiBao() throws SQLException {
		dao.connection.setAutoCommit(false);
		try {
			driver.get("http://localhost:8080/BankingServiceWebSite/");
			driver.findElement(By.id("log_in_button")).click();
			driver.findElement(By.id("username")).sendKeys("thinhme99");
			driver.findElement(By.id("password")).sendKeys("thinh12345");
			driver.findElement(By.id("dologin")).click();
			driver.findElement(By.id("vay_lai_button")).click();
			driver.findElement(By.id("name")).sendKeys("t");
			driver.findElement(By.id("tim_kiem_khach_hang")).click();
			String tenKH = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
			String expectedTenKH = "Ta Xuan Toan";

			driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).click();
			String SoCMND = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText();
			String expectedSoCMND = "001088011195";
			assertEquals(SoCMND, expectedSoCMND);
			String ngheNghiep = driver.findElement(By.xpath("//table[2]/tbody[1]/tr[1]/td[2]")).getText();
			String chucVu = driver.findElement(By.xpath("//table[2]/tbody[1]/tr[1]/td[3]")).getText();
			String tenCT = driver.findElement(By.xpath("//table[2]/tbody[1]/tr[1]/td[4]")).getText();
			String dcCongTy = driver.findElement(By.xpath("//table[2]/tbody[1]/tr[1]/td[5]")).getText();
			String expectedNN = "Developer JAVA";
			assertEquals(expectedNN, ngheNghiep);
			driver.findElement(By.xpath("//table[2]/tbody[1]/tr[1]/td[10]")).click();
			String title = driver.getTitle();
			String expectedTitle = "Sửa thông tin khai báo";
			assertEquals(title, expectedTitle);
			String ngheNghiepED = driver.findElement(By.id("Nghenghiep")).getAttribute("value");
			String chucVuED = driver.findElement(By.id("Chucvu")).getAttribute("value");
			String tenCTED = driver.findElement(By.id("Tencongty")).getAttribute("value");
			String dcCongTyED = driver.findElement(By.id("Diachicongty")).getAttribute("value");
			assertEquals(ngheNghiep, ngheNghiepED);
			assertEquals(chucVu, chucVuED);
			assertEquals(tenCT, tenCTED);
			assertEquals(dcCongTy, dcCongTy);
			driver.findElement(By.id("Chucvu")).sendKeys("Project Leader");
			driver.findElement(By.id("mucluong4")).click();
			driver.findElement(By.id("chitieu3")).click();
			driver.findElement(By.id("submit_button")).click();
			String notifyMess = driver.switchTo().alert().getText();
			String expectedMes = "Sửa tờ khai thành Công!!!";
			assertEquals(notifyMess, expectedMes);
			driver.switchTo().alert().accept();
			String title1 = driver.getTitle();
			String expectedTitle1 = "Danh sách Tờ Khai";
			assertEquals(title1, expectedTitle1);

			driver.close();
		} finally {
			dao.connection.rollback();
			dao.connection.close();
		}
	}
	@Test
	public void huysua_thongtinKhaiBao() throws SQLException {
	
			driver.get("http://localhost:8080/BankingServiceWebSite/");
			driver.findElement(By.id("log_in_button")).click();
			driver.findElement(By.id("username")).sendKeys("thinhme99");
			driver.findElement(By.id("password")).sendKeys("thinh12345");
			driver.findElement(By.id("dologin")).click();
			driver.findElement(By.id("vay_lai_button")).click();
			driver.findElement(By.id("name")).sendKeys("t");
			driver.findElement(By.id("tim_kiem_khach_hang")).click();
			String tenKH = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
			String expectedTenKH = "Ta Xuan Toan";
			driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).click();
			String SoCMND = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText();
			String expectedSoCMND = "001088011195";
			assertEquals(SoCMND, expectedSoCMND);

			driver.findElement(By.xpath("//table[2]/tbody[1]/tr[1]/td[10]")).click();
			String title = driver.getTitle();
			String expectedTitle = "Sửa thông tin khai báo";
			assertEquals(title, expectedTitle);
			
			driver.findElement(By.id("cancel_kb_button")).click();
			String title1 = driver.getTitle();
			String expectedTitle1 = "Danh sách Tờ Khai";
			assertEquals(title1, expectedTitle1);

			driver.close();
		
	}
	@Test
	public void delete_thongtinKhaiBao() throws SQLException {
		connection.setAutoCommit(false);
		try {
			driver.get("http://localhost:8080/BankingServiceWebSite/");
			driver.findElement(By.id("log_in_button")).click();
			driver.findElement(By.id("username")).sendKeys("thinhme99");
			driver.findElement(By.id("password")).sendKeys("thinh12345");
			driver.findElement(By.id("dologin")).click();
			driver.findElement(By.id("vay_lai_button")).click();
			driver.findElement(By.id("name")).sendKeys("t");
			driver.findElement(By.id("tim_kiem_khach_hang")).click();
			
			driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).click();
			String SoCMND = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText();
			String expectedSoCMND = "001088011195";
			assertEquals(SoCMND, expectedSoCMND);
			
			driver.findElement(By.xpath("//table[2]/tbody[1]/tr[1]/td[9]")).click();
			String notifyMess = driver.switchTo().alert().getText();
			String expectedMes = "Xóa tờ khai thành Công!!!";
			assertEquals(notifyMess, expectedMes);
			driver.switchTo().alert().accept();
			String title = driver.getTitle();
			String expectedTitle = "Danh sách Tờ Khai";
			assertEquals(title, expectedTitle);

		} finally {
			connection.rollback();
			connection.close();
			driver.close();
		}
	}
}
