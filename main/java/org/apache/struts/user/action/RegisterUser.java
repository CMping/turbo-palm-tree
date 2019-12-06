/**
 * Register Action class: Once invoked lets user to register an account.
 * 
 * @author Huang Yanping
 * @version 1.0
 * @since   2019-09-28
 */

package org.apache.struts.user.action;

import org.apache.struts.user.dao.UserManager;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class RegisterUser extends ActionSupport{
    private static final long serialVersionUID = 1;	
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String cPassword;
    private int type; 
    private String errorMessage;
    
    /**
 	 * Validations for Email.
 	 * Making sure the email input follows the the regular expression
 	 */
    
    private boolean validEmail(String email2) {
		// TODO Auto-generated method stub
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$";                
        Pattern pat = Pattern.compile(emailRegex); 
        return pat.matcher(email2).matches(); 
    }
    
    /**
   	 * User are able to register an account
   	 */
       
	public String execute() throws SQLException {
		if (getFirstName().length() == 0) {
			setErrorMessage("Input First Name, First Name is Required");
			return "FAILURE";
		} 
		else if (getEmail().length() == 0) {
			setErrorMessage("Input Email, Email is Required");
			return "FAILURE";
		}
		else if (validEmail(getEmail())==false)  {
			setErrorMessage("Invalid Email");
			return "FAILURE";
		}
		else if (UserManager.emailExists(email)) {
			setErrorMessage("Email already in used");
			return "FAILURE";
		}
		else if (getPassword().length() == 0) {
			setErrorMessage("Input Password, Password is Required");
			return "FAILURE";
		}
		else if (getcPassword().length() == 0) {
			setErrorMessage("Input Confirm Password, Confirm Password is Required");
			return "FAILURE";
		}
		else if (!getPassword().equals(getcPassword())) {
			setErrorMessage("Different Password & Confirm Password");
			return "FAILURE";
		} else { 
	    	UserManager.createUser(firstName, lastName, email, password, type);
	        return SUCCESS;
    	}
	}
    
	/**
	 * Get FirstName
	 */
    
    public String getFirstName() {
        return firstName;
    }
    
	/**
	 * Set FirstName
	 */
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
	/**
	 * Get LastName
	 */
    
    public String getLastName() {
        return lastName;
    }
    
	/**
	 * Set LastName
	 */
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    
	/**
	 * Get ConfirmPassword
	 */
    
	public String getcPassword() {
		return cPassword;
	}
    
	/**
	 * Set ConfirmPassword
	 */
    
	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}
    
	/**
	 * Get Type
	 */
    
	public int getType() {
        return type;
    }
    
	/**
	 * Set Type
	 */
    
    public void setType(int type) {
        this.type = type;
    }

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
    
}