package com.utrack.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomPasswordGenerator {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new PasswordEncoder() {

			@Override
			public boolean matches(CharSequence rawPassword, String hashPassword) {
				System.out.println("********************************************");
				System.out.println(
						"************password*** : " + rawPassword.toString() + "       hash : " + hashPassword);
				System.out.println("********************************************");
				if(rawPassword.toString().equals(hashPassword)) {
					System.out.println("equals");
					return true;
				}
				return BCrypt.checkpw(rawPassword.toString(), hashPassword);
			}

			@Override
			public String encode(CharSequence rawPassword) {
				System.out.println("rawpassowrd %%%%%%%% : " + rawPassword);
				return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(10));
			}
		};
	}

}
