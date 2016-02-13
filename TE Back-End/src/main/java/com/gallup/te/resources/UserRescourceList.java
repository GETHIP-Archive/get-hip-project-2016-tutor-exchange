
package com.gallup.te.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.gallup.te.DataSourceManager;
import com.gallup.te.model.User;
import com.j256.ormlite.dao.Dao;

@Path("/api/userlist")
public class UserRescourceList {

	@GET
	@Produces("application/json")
	public List<User> getUser(@QueryParam("param") String param, @QueryParam("type") String type) {
		try {
				if(type.equals("lName")){
					List<User> send = getDao().queryForEq("lName", param);
					if (send == null) {
						return null;
					} else {
						return send;
					}
				}else if(type.equals("username")){
					List<User> send = getDao().queryForEq("username", param);
					if (send == null) {
						return null;
					} else {
						return send;
					}
				}
		
			}catch(SQLException e){
				e.printStackTrace();
				return null;
			}
		return null;
		}
	
	private Dao<User, String> getDao() {
		Dao<User, String> dao = DataSourceManager.getInstance().getDao(User.class);
		return dao;

	}
}
	
	
	
