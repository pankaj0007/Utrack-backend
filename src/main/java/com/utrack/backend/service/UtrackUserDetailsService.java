package com.utrack.backend.service;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.utrack.backend.dao.UserDAO;
import com.utrack.backend.model.User;

@Service
@Transactional
public class UtrackUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername");
		User user = userDAO.findUserByName(username);
		if (user == null) {
			throw new UsernameNotFoundException("username " + username + " not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
				getAuthorities(user));
	}

	public Collection<GrantedAuthority> getAuthorities(User user) {
		System.out.println("getAuthorities");
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		if (user.getRole().getName().equalsIgnoreCase("admin")) {
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authorities;
	}

}
