package com.utrack.backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.utrack.backend.interceptor.IAuditLog;

@Entity
@Table(name = "users")
public class User implements IAuditLog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id")
	private Role role;

	@JsonIgnore
	private String previousRecord;

	public User(String name, String password, Role role) {
		super();
		this.name = name;
		this.password = password;
		this.role = role;
	}

	public User() {
		super();
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Transient
	@Override
	@JsonIgnore
	public String getCurrentData() {
		StringBuilder builder = new StringBuilder();
		builder.append("User Name : ").append(this.getName()).append(", Role : ").append(this.getRole().getName());
		return builder.toString();
	}

	@Override
	public String getPreviousData() {
		return this.previousRecord;
	}

	@Transient
	@Override
	@JsonIgnore
	public int getEntityId() {
		return this.getId();
	}

	@JsonIgnore
	public void createPreviousRecord(User user) {
		StringBuilder builder = new StringBuilder();
		builder.append("User Name : ").append(user.getName()).append(", Role : ").append(user.getRole().getName());
		this.previousRecord = builder.toString();
	}

}
