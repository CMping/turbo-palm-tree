/**
 * Forget Password Action class: Once invoked lets admin or user to retrieve password 
 * 
 * @author Huang Yanping
 * @version 1.0
 * @since   2019-09-28
 */

package org.apache.struts.user.action;

import org.apache.struts.user.dao.UserManager;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ForgetPassword extends ActionSupport{
    private static final long serialVersionUID = 1;
    private String email;
    private String password;
    private String errorMessage;
    ResultSet rs = null;
    
    /**
	 * User and admin are able to retrieve password
	 */
    
    public String execute() throws SQLException{
    
    /**
    * Validate whether the email is registered 
    * if not registered
    * return to forget password page with error message "Email not registered yet"
    */
    	
        if (!UserManager.emailExists(email)) {
            setErrorMessage("Email not registered yet");
            System.out.println(email);
            return "FAILURE";
        } else {          	
        	rs = UserManager.fetchDetails(email);
        	if (rs != null) {
				while (rs.next()) {
        	password = rs.getString("password");
        	System.out.println(email);
        	System.out.println(password);
        	setErrorMessage("Password Has Been Send To Your Email Address");
				}
        	}   	
		return "SUCCESS";
        }
    }
    
	/**
	 * Get Email
	 */

    public String getEmail() {
        return email;
    }
    
	/**
	 * Set Email
	 */
    
    public void setEmail(String email) {
        this.email = email;
    }
    
	/**
	 * Get ErrorMessage
	 */
    
    public String getErrorMessage() {
        return errorMessage;
    }
    
	/**
	 * Set ErrorMessage
	 */
    
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
	/**
	 * Get Password
	 */
    
	public String getPassword() {
		return password;
	}
    
	/**
	 * Set Password
	 */
    
	public void setPassword(String password) {
		this.password = password;
	}
}