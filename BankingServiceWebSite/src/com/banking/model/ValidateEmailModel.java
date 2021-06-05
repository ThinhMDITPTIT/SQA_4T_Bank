package com.banking.model;

public class ValidateEmailModel {
	
	public ValidateEmailModel() {
		
	}
	
	public boolean isEmail(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}
}
