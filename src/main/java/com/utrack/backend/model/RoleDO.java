package com.utrack.backend.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RoleDO extends BaseDO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@OneToMany(targetEntity = UserDO.class, mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<UserDO> users;

	private String comment;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RoleDO(long roleId, String name, Set<UserDO> users , String comment) {
		super();
		this.id = roleId;
		this.name = name;
		this.users = users;
		this.comment = comment;
	}

	public RoleDO(String name) {
		this.name = name;
	}

	public RoleDO() {
		super();
	}

}
