package com.epam.carrental.domain;

import java.util.Objects;

public class User {
	//VARIABLES
	private long userId;
	private String userName;
	private String userEmail;
	private String userAdress;
	private String userPassword;
	private boolean userBlocked;
	private UserRole userRole;
	//constructors
	public User() {
		super();
	}
	public User(String userName, String userEmail, String userAdress, String userPassword, boolean userBlocked,
			UserRole userRole) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userAdress = userAdress;
		this.userPassword = userPassword;
		this.userBlocked = userBlocked;
		this.userRole = userRole;
	}
	public User(long userId, String userName, String userEmail, String userAdress, String userPassword,
			boolean userBlocked, UserRole userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userAdress = userAdress;
		this.userPassword = userPassword;
		this.userBlocked = userBlocked;
		this.userRole = userRole;
	}
	//Getters&Setters
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAdress() {
		return userAdress;
	}
	public void setUserAdress(String userAdress) {
		this.userAdress = userAdress;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public boolean isUserBlocked() {
		return userBlocked;
	}
	public void setUserBlocked(boolean userBlocked) {
		this.userBlocked = userBlocked;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	//to string
	@Override
	public String toString() {
		return "user [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userAdress="
				+ userAdress + ", userPassword=" + userPassword + ", userBlocked=" + userBlocked + ", userRole="
				+ userRole + "]";
	}
	//hash code
	@Override
	public int hashCode() {
		return Objects.hash(userAdress, userBlocked, userEmail, userId, userName, userPassword, userRole);
	}
	//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userAdress, other.userAdress) && userBlocked == other.userBlocked
				&& Objects.equals(userEmail, other.userEmail) && userId == other.userId
				&& Objects.equals(userName, other.userName) && Objects.equals(userPassword, other.userPassword)
				&& userRole == other.userRole;
	}
	
}
 