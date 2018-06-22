package com.utrack.backend.authentication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class UtrackAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		System.out.println("commence");
		response.setHeader("WWW-Authenticate", "Basic realm - " + getRealmName());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter printWriter = response.getWriter();
		printWriter.println("HTTP status code " + authException.getMessage());

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		setRealmName("Utrack");
		super.afterPropertiesSet();
	}
}
