package com.fwindhagauer.messenger.entitiy;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User extends BaseEntity{
	private String username;

	private String pw;

	private String salt;

	private long userRoleId;

	private boolean registrationAccepted;

	public User(String username, String pw, String salt, long userRoleId, boolean registrationAccepted) {
		this.username = username;
		this.pw = pw;
		this.salt = salt;
		this.userRoleId = userRoleId;
		this.registrationAccepted = registrationAccepted;
	}

	public User(){
		this.registrationAccepted = false;
	}

	@Column(name = "username", nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "pw", nullable = false)
	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Column(name = "salt", nullable = false)
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Column(name = "user_role_id", nullable = false)
	public long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}

	@Column(name = "registration_accepted", nullable = false)
	public boolean isRegistrationAccepted() {
		return registrationAccepted;
	}

	public void setRegistrationAccepted(boolean registrationAccepted) {
		this.registrationAccepted = registrationAccepted;
	}
}
