
package com.gallup.te.resources;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.gallup.te.DataSourceManager;
import com.gallup.te.model.User;
import com.j256.ormlite.dao.Dao;

@Path("/api/user")
public class UserRescource {

	@GET
	@Produces("application/json")
	public User getUser(@QueryParam("param") String uId, @QueryParam("searchBy") String filterBy) {
		try {
			if (filterBy.equals("param")) {
				User send = getDao().queryForId(uId);
				if (send == null) {
					return null;
				} else {
					return send;
				}
			} else if (filterBy.equals("lName")) {

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
	public String addUser(User u){
		User tempUser;
		int preID = u.getUserID
		try {
			tempUser = getDao().createIfNotExists(u);
			if (tempUser == null) {
				// If issue in SQL or JSON
				return "Problem In Creation";
			} else {
				if (tempUser.getUserID() == preID) {
					// If ID already exists
					return "Already Esists";
				} else {
					// If creating a user with duplicate studentID
					if (getDao().queryForEq("username", u.getUsername()).size() > 1) {
						return "invalid username";
						// Creating a new user with unique studentID
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

	private Dao<User, String> getDao() {
		Dao<User, String> dao = DataSourceManager.getInstance().getDao(User.class);
		return dao;

	}
}