package model.business;

import java.sql.SQLException;
import model.dataccess.LoginDataAccess;
import model.entities.MessageException;
import model.entities.User;

public class LoginBusiness {
	
	private static User user;
	private static LoginDataAccess loginDataInstance;
	
	public void ValidateAndAuthenticate(String userName, String password) throws ClassNotFoundException, SQLException {
		
		if (userName.equals("")) {
			throw new MessageException("Username not informed.");
		} else if (password.equals("")) {
			throw new MessageException("Password not informed.");
		}
		
		//User user = new User(userName, password);
		
		if(getUserInstance() == null) {
			
			user = new User(userName, password);
		}
		
		else {
			
			user = getUserInstance();
			user.setUserName(userName);
			user.setPassword(password);
		}
		
		if(getUserInstance() == null) {
			
			user = new User(userName, password);
		}
		
		else {
			
			user = getUserInstance();
			user.setUserName(userName);
			user.setPassword(password);
		}
		
		
		if (!(new LoginDataAccess().verifyCredentials(user))) {
			throw new MessageException("Incorrect credentials.");
		}
	}
	
	public static User getUserInstance() {
		
		return user;
	}
	
	public static LoginDataAccess getLoginDataInstance() {
		
		return loginDataInstance;
	}
}
