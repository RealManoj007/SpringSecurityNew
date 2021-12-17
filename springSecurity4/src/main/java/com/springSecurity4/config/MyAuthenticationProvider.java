package com.springSecurity4.config;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username=authentication.getName();
		String password=authentication.getCredentials().toString();
		System.out.println("\n"+username+" : "+password+"\n");
		if("abc".equals(username)&& "123".equals(password)) {
			System.out.println("\nValue from is "+username+" : "+password+"\n");
			return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
		}else {
			throw new BadCredentialsException("Invalid username and password");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
	
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
