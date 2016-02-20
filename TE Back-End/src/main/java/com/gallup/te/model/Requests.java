package com.gallup.te.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@XmlRootElement
@DatabaseTable(tableName="Requests")

public class Requests {

	@DatabaseField(generatedId = true, columnName = "requestID")
	private int requestID;
	@DatabaseField(columnName = "subject")
	private String subject;
	@DatabaseField(columnName = "tutorID")
	private int tutorID;
	@DatabaseField(columnName = "tuteeID")
	private int tuteeID;
	@DatabaseField(columnName = "description")
	private String description;
	@DatabaseField(columnName = "schedule")
	private int schedule;
	
	public Requests(){
		
	}
	
	public int RequestID() {
		return requestID;
	}
	
	
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	
	public int TutorID() {
		return tutorID;
	}
	
	
	public void setTutorID(int tutorID) {
		this.tutorID = tutorID;
	}
	
	public int TuteeID() {
		return tuteeID;
	}
	
	
	public void setTuteeID(int tuteeID) {
		this.tuteeID = tuteeID;
	}
	
	public String Description() {
		return description;
	}
	
	
	public void setDescriptiontID(String description) {
		this.description = description;
	}
	
	public int Schedule() {
		return schedule;
	}
	
	
	
	public void setSchedule(int schedule) {
		this.schedule = schedule;
	}
	
}
