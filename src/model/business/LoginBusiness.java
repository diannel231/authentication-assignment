package model.business;

import java.sql.SQLException;
import model.dataccess.LoginDataAccess;
import model.entities.MessageException;
import model.entities.User;

public class LoginBusiness {
	
	public void ValidateAndAuthenticate(String userName, String password) throws ClassNotFoundException, SQLException {
		
		if (userName.equals("")) {
			throw new MessageException("Username not informed.");
		} else if (password.equals("")) {
			throw new MessageException("Password not informed.");
		}
		
		User user = new User(userName, password);
		
		if (!(new LoginDataAccess().verifyCredentials(user))) {
			throw new MessageException("Incorrect credentials.");
		}
	}
}
