package com.utrack.backend.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.utrack.backend.service.UtrackUserDetailsService;

@EnableWebSecurity
public class UtrackSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UtrackAuthenticationEntryPoint entryPoint;

	@Autowired
	private UtrackUserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("configure Auth");
		// super.configure(auth);
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("configure http");
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic().authenticationEntryPoint(entryPoint)
				.and().csrf().disable();
	}

	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

}
