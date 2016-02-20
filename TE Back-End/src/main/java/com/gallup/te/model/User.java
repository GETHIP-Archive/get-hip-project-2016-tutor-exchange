package com.gallup.te.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@XmlRootElement
@DatabaseTable(tableName="Users")
public class User {
	
	@DatabaseField(generatedId = true, columnName = "userID")
	private int userID;
	@DatabaseField(columnName = "lName")
	private String lName;
	@DatabaseField(columnName = "fName")
	private String fName;
	@DatabaseField(columnName = "gLevel")
	private int gLevel;
	@DatabaseField(columnName = "gender")
	private String gender;
	@DatabaseField(columnName = "role")
	private int role;
	@DatabaseField(columnName = "username")
	private String username;
	@DatabaseField(columnName = "password")
	private String password;
	
	
	public User(){
		
	}
	
	public User(int userID, String lName, String username, String fName, int gLevel, String gender, int role, String password){
		this.userID = userID;
		this.lName = lName;
		this.fName = fName;
		this.gLevel = gLevel;
		this.gender = gender;
		this.role = role;
		this.password = password;
		this.username = username;
	}
	
	public int getUserID() {
		return userID;
	}
	
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getLastName() {
		return lName;
	}

	public void setLastName(String lName) {
		this.lName = lName;
	}

	public String getFirstName() {
		return fName;
	}

	public void setFirstName(String fName) {
		this.fName = fName;
	}
	
	public int getGradeLevel() {

		return gLevel;

	}

	public void setGradeLevel(int gLevel) {
		this.gLevel = gLevel;
	}
	
	public String getUsername() {

		return username;

	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getGender() {
		return gender;

	}

	public void setGender(String gender) {

		this.gender = gender;
	}
	
	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	
	
}