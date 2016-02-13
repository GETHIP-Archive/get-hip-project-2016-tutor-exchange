
package com.gallup.te.resources;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.gallup.te.DataSourceManager;
import com.gallup.te.model.User;
import com.j256.ormlite.dao.Dao;

@Path("/api/userid")
public class UserRescource {

	@GET
	@Produces("application/json")
	public User getUser(@QueryParam("param") String param) {
		try {
				User send = getDao().queryForId(param);
				if (send == null) {
					return null;
				} else {
					return send;
				}
			}catch(SQLException e){
				e.printStackTrace();
				return null;
			}
		}

	@POST
	@Produces("text/plain")
	@Consumes("application/json")
	public String addUser(User u){
		User tempUser;
		int preID = u.getUserID();
		try {
			tempUser = getDao().createIfNotExists(u);
			if (tempUser == null) {
				return "Problem In Creation";
			} else {
				if (tempUser.getUserID() == preID) {
					return "Already Esists";
				} else {
					if (getDao().queryForEq("username", u.getUserName()).size() > 1) {
						//Response.ok(json,MediaType.APPLICATION_JSON);
						//Response.notModified("User already exists");
						return "invalid username";
					} else {
						return "created";
				
				}
				}
					}
			}
		catch (SQLException e) {
			e.printStackTrace();
			return "Error";
		}
	}

	@PUT
	@Produces("text/plain")
	@Consumes("application/json")
	public String updateUser(User u) {
		try {
			int rowsChanged = getDao().update(u);
			if (rowsChanged == 0) {
				return "No entries found for User " + u.getUserID();
			} else if (rowsChanged > 1) {
				return "Error With Updating User " + u.getUserID();
			} else if (rowsChanged == 1) {
				return "Entry updated for User " + u.getUserID();
			}
		} catch (SQLException e) {
			return "Error";
		}
		return null;
	}

	@DELETE
	@Produces("test/plain")
	public String deleteUser(@QueryParam("uID") String uID) {
		try {
			int rowsChanged = getDao().deleteById(uID);
			if (rowsChanged == 1) {
				return "User " + uID + " removed";
			} else if (rowsChanged == 0) {
				return "User " + uID + " not found";
			} else {
				return "Issue with Delete";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error";
		}

	}

	private Dao<User, String> getDao() {
		Dao<User, String> dao = DataSourceManager.getInstance().getDao(User.class);
		return dao;

	}
}