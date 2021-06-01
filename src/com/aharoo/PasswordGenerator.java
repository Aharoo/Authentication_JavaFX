package com.aharoo;

import java.security.SecureRandom;

public class PasswordGenerator {

	SecureRandom randomChar = new SecureRandom();

	public String generateRandomPassword(){
		String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smallLetters = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "1234567890";
		String symbols = "!@#$%^&*_=+/?<>";
		String values = capitalLetters + smallLetters + numbers + symbols;
		char[] password = new char[12];
		for (int i = 0; i < 12; i++){
			password[i] = values.charAt(randomChar.nextInt(values.length()));
		}
		String passwordString = String.valueOf(password);
		return passwordString;
	}
}
