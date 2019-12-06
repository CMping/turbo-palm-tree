/**
 * Admin Create Admin Action class: Once invoked lets Admin create another admin account 
 * 
 * @author Huang Yanping
 * @version 1.0
 * @since   2019-09-28
 */

package org.apache.struts.user.action;

import org.apache.struts.user.model.User;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts.user.dao.UserManager;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.util.Map;
import java.util.regex.Pattern;

public class CreateAdmin extends ActionSupport implements SessionAware{
    private static final long serialVersionUID = 1;
    private User user;	
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String cPassword;
    private int type; 
    private String msg;
    Map<String,Object> sessionmap;
    
    /**
	 * Admin are able to create another admin account
	 */
    
     public String execute() throws SQLException {
    	 
    	 /**
     	 *  Validate the session by checking the email and access type. 
     	 */
    	 
    	if (sessionmap.containsKey("email")&&(sessionmap.containsKey("private"))) {
    		
    	int ctr = UserManager.createAdmin(firstName, lastName, email, password, type);
    	if (ctr > 0) {
			msg = "Admin Account Created Successfuly";
			} else {
				msg = "error";
			}
    		return SUCCESS;
    	} else {
    		return "LOGIN";
    	}
    }
     
 	/**
 	 * Validations for First Name, Last Name, Email, Confirm Password and Password. These 5 fields are
 	 * mandatory. If not entered, error message will be shown. Once create account is
 	 * successful, successful message is shown.
 	 */
     
    public void validate() {
    	if (getFirstName().length() == 0) 
    		addFieldError("firstName","Input First Name Here, First Name is Required");
    	
    	if (getEmail().length() == 0) 
    		addFieldError("email","Input Email Here, Email is Required");
    	
    	if (validEmail(getEmail())==false) 
			addFieldError("email"," Invalid Email");
	
    	try {
			if (UserManager.emailExists(email)) 
				addFieldError("email","Email Already Exist");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	if (getPassword().length() == 0) 
    		addFieldError("password","Input Password Here, Password is Required");
    	
    	if (getcPassword().length() == 0) 
    		addFieldError("cPassword","Input Password Here, Confirm Password is Required");
    	
    	if (!getPassword().equals(getcPassword())) 
    		addFieldError("cPassword","Different Password & Confirm Password");
    }
    
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
	 * Get User
	 */
    
	public User getUser() {
        return user;
    }
    
	/**
	 * Set User
	 */
    
    public void setUser(User user) {
        this.user = user;
    }
    
	/**
	 * Get FirstName
	 */
    
    public String getFirstName() {
        return firstName;
    }
    
	/**
	 * Set LastName
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
	 * Get Confirm Password
	 */
    
	public String getcPassword() {
		return cPassword;
	}
    
	/**
	 * Set Confirm Password
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
	 * Get Msg
	 */
    
	public String getMsg() {
		return msg;
	}
    
	/**
	 * Set Msg
	 */
    
	public void setMsg(String msg) {
		this.msg = msg;
	}
    
	/**
	 * Get SessionMap
	 */
    
	public Map<String, Object> getSessionmap() {
		return sessionmap;
	}
    
	/**
	 * Set SessionMap
	 */
    
	public void setSession(Map<String, Object> session) {
		this.sessionmap = session;	
	}
}