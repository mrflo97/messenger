package com.fwindhagauer.messenger.entitiy;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole extends BaseEntity {
	private String name;

	public UserRole(String name) {
		this.name = name;
	}

	public UserRole(){
		super();
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
