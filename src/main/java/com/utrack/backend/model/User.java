package com.utrack.backend.model;

public class User {

	private String name;
	private String password;
	private Role role;

	public User(String name, String password, Role role) {
		super();
		this.name = name;
		this.password = password;
		this.role = role;
	}

	public User() {
		super();
	}

	public enum Role {
		admin("ADMIN"), emp("emp");
		private String role;

		private Role(String role) {
			this.role = role;
		}
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public Role getRole() {
		return role;
	}

}
