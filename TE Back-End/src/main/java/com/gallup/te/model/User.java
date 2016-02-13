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
	@DatabaseField(columnName = "name")
	private String name;
	@DatabaseField(columnName = "gLevel")
	private int gLevel;
	@DatabaseField(columnName = "gender")
	private String gender;
	@DatabaseField(columnName = "role")
	private int role;
	@DatabaseField(unique = true, columnName = "uName")
	private String uName;
	@DatabaseField(unique = true, columnName = "password")
	private String password;
	
	
	public User(){
		
	}
	
	public User(int userID, String lName, String name, int gLevel, String gender, int role, String uName, String password){
		this.userID = userID;
		this.lName = lName;
		this.name = name;
		this.gLevel = gLevel;
		this.gender = gender;
		this.role = role;
		this.uName = uName;
		this.password = password;
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
		return name;
	}

	public void setFirstName(String name) {
		this.name = name;
	}
	
	public int getGradeLevel() {

		return gLevel;

	}

	public void setGradeLevel(int gLevel) {
		this.gLevel = gLevel;
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

	public String getUserName(){
		return uName;
	}
	
	public void setUsername(String uName){
		this.uName = uName;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	
	
}