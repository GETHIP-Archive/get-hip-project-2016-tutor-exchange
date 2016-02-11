package com.gallup.te.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@XmlRootElement
@DatabaseTable(tableName="Users")
public class User {
	
	@DatabaseField(generatedId = true, columnName = "userID")
	private int userID;
	

	
	
	
}