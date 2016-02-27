package com.gallup.te.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@XmlRootElement
@DatabaseTable(tableName="Requests")

public class Request {

	@DatabaseField(generatedId = true, columnName = "requestID")
	private int requestID;
	@DatabaseField(columnName = "subject")
	private String subject;
	@DatabaseField(columnName = "tutorID", foreign = true, foreignAutoRefresh=true)
	private User tutorID;
	@DatabaseField(columnName = "tuteeID", foreign = true, foreignAutoRefresh=true)
	private User tuteeID;
	@DatabaseField(columnName = "description")
	private String description;
	
	public Request(){
		
	}
	
	public int getRequestID() {
		return requestID;
	}
	
	
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	
	public User getTutorID() {
		return tutorID;
	}
	
	
	public void setTutorID(User tutorID) {
		this.tutorID = tutorID;
	}
	
	public User getTuteeID() {
		return tuteeID;
	}
	
	
	public void setTuteeID(User tuteeID) {
		this.tuteeID = tuteeID;
	}
	
	public String getDescription(){
		return description;
		
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	
	
	public String getSubject(){
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}

	

	
}
