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
public class UserDO extends BaseDO implements IAuditLog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "userfullname")
	private String fullName;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "roleid")
	private RoleDO role;

	@Column(name = "isactive")
	private Short active;

	@Column(name = "needtochangepassword")
	private Short passwordChange;

	@Column(name = "remember_token")
	private String isRememberToken;

	@JsonIgnore
	private String previousRecord;

	public UserDO(String name, String password, RoleDO role, String email) {
		super();
		this.name = name;
		this.password = password;
		this.role = role;
		this.email = email;
	}

	public UserDO() {
		super();
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public RoleDO getRole() {
		return role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
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
	public Long getEntityId() {
		return this.getId();
	}

	@JsonIgnore
	public void createPreviousRecord(UserDO user) {
		StringBuilder builder = new StringBuilder();
		builder.append("User Name : ").append(user.getName()).append(", Role : ").append(user.getRole().getName());
		this.previousRecord = builder.toString();
	}

}
