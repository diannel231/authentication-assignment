package model.business;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import model.dataccess.LoginDataAccess;
import model.entities.MessageException;
import model.entities.User;

public class LoginBusiness {
	
	public void ValidateFields(String userName, String password) {
		
		if (userName.equals("")) {
			throw new MessageException("Username not informed.");
		} else if (password.equals("")) {
			throw new MessageException("Password not informed.");
		}

	}
	
	public boolean AuthenticateUser(String userName, String password) throws ClassNotFoundException, SQLException {
		
		boolean success = true;
		
		User user = new User(userName, password);
		
		if (!(new LoginDataAccess().verifyCredentials(user))) {
			success = false;
			throw new MessageException("Incorrect credentials.");
		}
		return success;
	}
	
	
}
