package com.banking.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	private static String DB_NAME = "sqa";
	private static String USER_NAME = "root";
	private static String PASSWORD = "admin";

	private static String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME + "?autoReconnect=true&useSSL=false";
	public static Connection connection;

	public DAO() {
		if (connection == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
				System.out.println("connect successfully!");
			} catch (Exception ex) {
				System.out.println("connect failure!");
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		DAO dao = new DAO();
		System.out.println(connection);
	}
}
