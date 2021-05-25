package com.banking.test_selenium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestChucNangTinhLaiVayTMD extends TestDriver {

	ChromeDriver driver = getDriver();

	@Test
	public void log_in_title() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		String title = driver.getTitle();
		String expectedTitle = "Đăng nhập";
		assertEquals(title, expectedTitle);
		driver.close();
	}

	@Test
	public void log_in() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		driver.findElement(By.id("log_in_button")).click();
		driver.findElement(By.id("username")).sendKeys("thinhme99");
		driver.findElement(By.id("password")).sendKeys("thinh12345");
		driver.findElement(By.id("dologin")).click();
		String title = driver.getTitle();
		String expectedTitle = "Trang chủ";
		assertEquals(title, expectedTitle);
		driver.close();
	}

	@Test
	public void log_out() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		driver.findElement(By.id("log_in_button")).click();
		driver.findElement(By.id("username")).sendKeys("thinhme99");
		driver.findElement(By.id("password")).sendKeys("thinh12345");
		driver.findElement(By.id("dologin")).click();
		driver.findElement(By.id("log_out_button")).click();
		String title = driver.getTitle();
		String expectedTitle = "Đăng nhập";
		assertEquals(title, expectedTitle);
		driver.close();
	}

	@Test
	public void timkiem_khachhang() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		driver.findElement(By.id("log_in_button")).click();
		driver.findElement(By.id("username")).sendKeys("thinhme99");
		driver.findElement(By.id("password")).sendKeys("thinh12345");
		driver.findElement(By.id("dologin")).click();
		driver.findElement(By.id("tinh_lai_button")).click();
		driver.findElement(By.id("name")).sendKeys("Ta Xuan Toan");
		driver.findElement(By.id("tim_kiem_khach_hang")).click();
		String title = driver.findElement(By.xpath("//table/tbody/tr/td[2]")).getText();
		String expectedTitle = "Ta Xuan Toan";
		assertEquals(title, expectedTitle);
		driver.close();
	}

	@Test
	public void xem_khoanvay_khachhang() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		driver.findElement(By.id("log_in_button")).click();
		driver.findElement(By.id("username")).sendKeys("thinhme99");
		driver.findElement(By.id("password")).sendKeys("thinh12345");
		driver.findElement(By.id("dologin")).click();
		driver.findElement(By.id("tinh_lai_button")).click();
		driver.findElement(By.id("name")).sendKeys("Ta Xuan Toan");
		driver.findElement(By.id("tim_kiem_khach_hang")).click();
		driver.findElement(By.id("xem_cac_khoan_vay")).click();
		String title = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText();
		String expectedTitle = "001088011195";
		assertEquals(title, expectedTitle);
		driver.close();
	}

	@Test
	public void xem_sodienthoai_khachhang() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		driver.findElement(By.id("log_in_button")).click();
		driver.findElement(By.id("username")).sendKeys("thinhme99");
		driver.findElement(By.id("password")).sendKeys("thinh12345");
		driver.findElement(By.id("dologin")).click();
		driver.findElement(By.id("tinh_lai_button")).click();
		driver.findElement(By.id("name")).sendKeys("Ta Xuan Toan");
		driver.findElement(By.id("tim_kiem_khach_hang")).click();
		driver.findElement(By.id("xem_cac_khoan_vay")).click();
		driver.findElement(By.xpath("//table[2]/tbody/tr/td[6]")).click();
		String title = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]")).getText();
		String expectedTitle = "0382999209";
		assertEquals(title, expectedTitle);
		driver.close();
	}

	@Test
	public void timkiem_khachhang_null() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		driver.findElement(By.id("log_in_button")).click();
		driver.findElement(By.id("username")).sendKeys("thinhme99");
		driver.findElement(By.id("password")).sendKeys("thinh12345");
		driver.findElement(By.id("dologin")).click();
		driver.findElement(By.id("tinh_lai_button")).click();
		driver.findElement(By.id("name")).sendKeys("Alo");
		driver.findElement(By.id("tim_kiem_khach_hang")).click();
		String title = driver.findElement(By.id("khong_ton_tai_khach_hang")).getText();
		String expectedTitle = "Không có khách hàng";
		assertEquals(title, expectedTitle);
		driver.close();
	}

}