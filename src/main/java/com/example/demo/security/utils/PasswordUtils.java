package com.example.demo.security.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

	public PasswordUtils() {
	}

	public static String gerarBCrypt(String senha) {
		if (senha == null) {
			return senha;
		}
		return new BCryptPasswordEncoder().encode(senha);
	}

}
