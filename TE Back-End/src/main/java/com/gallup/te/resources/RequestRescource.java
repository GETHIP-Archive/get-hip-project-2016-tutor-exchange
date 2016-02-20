
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

@Path("/api/userid")
public class RequestRescource {

	List<User> getSend(List<User> l) {
		if (l == null) {
			return null;
		} else {
			return l;
		}
	}

	//@GET
	//@Produces("application/json")

}
