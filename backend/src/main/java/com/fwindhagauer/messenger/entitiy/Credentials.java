package com.fwindhagauer.messenger.entitiy;

import javax.persistence.*;

@Entity
@Table(name = "credentials")
public class Credentials extends BaseEntity {
	private User user;

	private String pw;

	public Credentials(){
		super();
	}

	@OneToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "pw")
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
}
