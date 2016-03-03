
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
import com.gallup.te.model.Request;
import com.j256.ormlite.dao.Dao;

@Path("/api/request")
public class RequestRescource {

	List<Request> getSend(List<Request> l) {
		if (l == null) {
			return null;
		} else {
			return l;
		}
	}

	@GET
	@Produces("application/json")
	public List<Request> getRequest(@QueryParam("param") String param, @QueryParam("type") String type) {
		try {
			if (type.equals("requestID")) {
				return getSend(getDao().queryForEq("requestID", param));
			} else if (type.equals("tutorID")) {
				return getSend(getDao().queryForEq("tutorID", param));
			} else if (type.equals("tuteeID")) {
				return getSend(getDao().queryForEq("tuteeID", param));
			}else if(type.equals("status")){
				return getSend(getDao().queryForEq("status", param));
				
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
	public String addRequest(Request r) {
		Request tempRequest;
		int preID = r.getRequestID();
		try {
			tempRequest = getDao().createIfNotExists(r);
			if (tempRequest == null) {
				return "Problem In Creation";
			} else if (tempRequest.getRequestID() == preID) {
				return "Already Esists";
			} else {
				return "created";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return "Error";
		}
	}

	@PUT
	@Produces("text/plain")
	@Consumes("application/json")
	public String updateRequest(Request r) {
		try {
			int rowsChanged = getDao().update(r);
			if (rowsChanged == 0) {
				return "No entries found for User " + r.getRequestID();
			} else if (rowsChanged > 1) {
				return "Error With Updating User " + r.getRequestID();
			} else if (rowsChanged == 1) {
				return "Entry updated for User " + r.getRequestID();
			}
		} catch (SQLException e) {
			return "Error";
		}
		return null;
	}

	@DELETE
	@Produces("test/plain")
	public String deleteRequest(@QueryParam("param") String requestID) {
		try {
			int rowsChanged = getDao().deleteById(requestID);
			if (rowsChanged == 1) {
				return "User " + requestID + " removed";
			} else if (rowsChanged == 0) {
				return "User " + requestID + " not found";
			} else {
				return "Issue with Delete";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error";
		}

	}

	private Dao<Request, String> getDao() {
		Dao<Request, String> dao = DataSourceManager.getInstance().getDao(Request.class);
		return dao;

	}

}
