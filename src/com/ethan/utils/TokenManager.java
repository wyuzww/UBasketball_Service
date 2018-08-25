package com.ethan.utils;

public class TokenManager {
	public String makeToken(int user_id) {
		String token = String.valueOf(user_id)+System.currentTimeMillis();
		return token;
	}

}
