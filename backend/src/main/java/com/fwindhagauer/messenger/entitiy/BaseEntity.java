package com.fwindhagauer.messenger.entitiy;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
	private Integer id;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}

