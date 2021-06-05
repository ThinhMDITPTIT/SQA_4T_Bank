package com.banking.test.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.banking.model.ValidateEmailModel;

class TestValidateEmail {
	
	
	@Test
	void testSuccess() {
		String email = "shadowking1603@gmail.com";
		ValidateEmailModel validateEmailModel = new ValidateEmailModel();
		boolean expectedResult = true;
		boolean result = validateEmailModel.isEmail(email);
		assertEquals(expectedResult, result);
	}
	
	@Test
	void testFail1() {
		String email = "shadowking1603.com";
		ValidateEmailModel validateEmailModel = new ValidateEmailModel();
		boolean expectedResult = false;
		boolean result = validateEmailModel.isEmail(email);
		assertEquals(expectedResult, result);
	}
	@Test
	void testFail2() {
		String email = "shadowking1603";
		ValidateEmailModel validateEmailModel = new ValidateEmailModel();
		boolean expectedResult = false;
		boolean result = validateEmailModel.isEmail(email);
		assertEquals(expectedResult, result);
	}
	@Test
	void testFail3() {
		String email = "shadowking1603@gmail";
		ValidateEmailModel validateEmailModel = new ValidateEmailModel();
		boolean expectedResult = false;
		boolean result = validateEmailModel.isEmail(email);
		assertEquals(expectedResult, result);
	}

}
