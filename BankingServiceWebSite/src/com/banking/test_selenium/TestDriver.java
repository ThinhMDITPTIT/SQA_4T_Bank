package com.banking.test_selenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestDriver {
	private String driverUrl = "E:\\TaiLieuHocTap\\SQA document\\chromedriver.exe";

	public TestDriver() {
	}

	public ChromeDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", driverUrl);
		return new ChromeDriver();
	}
}
