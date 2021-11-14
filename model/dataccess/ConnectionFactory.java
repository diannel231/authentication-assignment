package model.dataccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection DBConnection() throws ClassNotFoundException, SQLException {
		
		final String URL = "jdbc:postgresql://localhost:5432/authentication";

		final String USER = "postgres";

		final String PWD = "123";

		Class.forName("org.postgresql.Driver");
		Connection conection = DriverManager.getConnection(URL, USER, PWD);
		
		return conection;
		
	}

}
