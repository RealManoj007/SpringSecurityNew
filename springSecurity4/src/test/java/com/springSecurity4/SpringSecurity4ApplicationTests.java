package com.springSecurity4;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SpringSecurity4ApplicationTests {

	@Test
	void textPasswordEncoder() {
		System.out.println("\u001B[31"+new BCryptPasswordEncoder().encode("123"));
	}

}
