package com.fwindhagauer.messenger.entitiy;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "contact")
public class Contact extends BaseEntity{
	private String name;

	private String imagePath;

	private boolean favourite = false;

	private User owner;

	public Contact(){}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "image_path", nullable = false)
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Column(name = "favourite", nullable = false)
	public boolean isFavourite() {
		return favourite;
	}
	public void setFavourite(boolean favourite) {
		this.favourite = favourite;
	}

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "owner_id")
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
}
