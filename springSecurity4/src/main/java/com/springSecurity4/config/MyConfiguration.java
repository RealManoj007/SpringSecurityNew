package com.springSecurity4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class MyConfiguration extends WebSecurityConfigurerAdapter{
//	@Autowired
//	private PasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private MyAuthenticationProvider authenticationProvider;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}	
//		InMemoryUserDetailsManager detailsManager=new InMemoryUserDetailsManager();
//		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
//		
//		UserDetails user= User.withUsername("abc")
//				.password(bCryptPasswordEncoder.encode("123"))
//				.authorities("read")
//				.build();
//		
//			detailsManager.createUser(user);
//			
//			auth.userDetailsService(detailsManager).passwordEncoder(bCryptPasswordEncoder);
//	}
	
//	@Bean
//	public PasswordEncoder bCryptPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.httpBasic();
//			http.authorizeHttpRequests().anyRequest().authenticated();
			http.authorizeHttpRequests().antMatchers("/home").authenticated();
			http.addFilterBefore(new MySecurityFilter(), BasicAuthenticationFilter.class);
		}
}
