
package com.gallup.te.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.gallup.te.DataSourceManager;
import com.gallup.te.model.User;
import com.j256.ormlite.dao.Dao;

@Path("/api/user")
public class UserRescource {

	List<User> getSend(List<User> l) {
		if (l == null) {
			return null;
		} else {
			return l;
		}
	}

	@GET
	@Produces("application/json")
	public List<User> getUser(@QueryParam("param") String param, @QueryParam("type") String type) {
		try {
			if (type.equals("lName")) {
				return getSend(getDao().queryForEq("lName", param));
			} else if (type.equals("username")) {
				return getSend(getDao().queryForEq("username", param));
			} else if (type.equals("userID")) {
				return getSend(getDao().queryForEq("userID", param));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@POST
	@Produces("text/plain")
	@Consumes("application/json")
	public String addUser(User u) {
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
					if (getDao().queryForEq("username", u.getUsername()).size() > 1) {
						// Response.ok(json,MediaType.APPLICATION_JSON);
						// Response.notModified("User already exists");
						return "invalid username";
					} else {
						return "created";

					}
				}
			}
		} catch (SQLException e) {
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
	public String deleteUser(@QueryParam("param") String uID) {
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