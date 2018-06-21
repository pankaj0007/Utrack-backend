package com.utrack.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	private String name;
	@Column(name = "password")
	private String password;
	@Column(name = "role")
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
