
package com.gallup.te;

import com.gallup.te.model.Request;
import com.gallup.te.model.User;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.server.impl.container.grizzly2.GrizzlyContainerProvider;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;


public class Main {
	
	private static void createDatabaseConnection(){
		String databaseUrl = "jdbc:mysql://jgetrost.com:3306/tutor";
		ConnectionSource connectionSource;
		try {
			connectionSource = new JdbcConnectionSource(databaseUrl);
			((JdbcConnectionSource)connectionSource).setUsername("tutor");
			((JdbcConnectionSource)connectionSource).setPassword("gethip");
			DataSourceManager.setConnectionSource(connectionSource);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void buildDaos(){
		try {
			DataSourceManager.addDao(User.class);
			DataSourceManager.addDao(Request.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    private static int getPort(int defaultPort) {
        //grab port from environment, otherwise fall back to default port 9998
        String httpPort = System.getProperty("jersey.test.port");
        if (null != httpPort) {
            try {
                return Integer.parseInt(httpPort);
            } catch (NumberFormatException e) {
            }
        }
        return defaultPort;
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/").port(getPort(9998)).build();
    }

    public static final URI BASE_URI = getBaseURI();
    
    protected static HttpServer startServer() throws IOException {
        ResourceConfig resourceConfig = new PackagesResourceConfig("com.gallup.te.resources");
        resourceConfig.getContainerResponseFilters().add("com.gallup.te.CORSResponseFilter");
        System.err.println("Adding cors filter");
        System.out.println("Starting grizzly2...");
        HttpServer server = GrizzlyServerFactory.createHttpServer(BASE_URI, resourceConfig);
        server.getServerConfiguration().addHttpHandler(new StaticHttpHandler("/Users/Jacob/Documents/GitHub/get-hip-project-2016-tutor-exchange/UI"), "/home");
        return server;
    }
    
    public static void main(String[] args) throws IOException {
        // Grizzly 2 initialization
        HttpServer httpServer = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...",
                BASE_URI));
        createDatabaseConnection();
        buildDaos();
        System.in.read();
        httpServer.stop();
    }    
}
