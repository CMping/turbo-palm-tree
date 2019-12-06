/**
 * View Create Admin page Action class: Once invoked lets admin to go Create Admin page
 * 
 * @author Huang Yanping
 * @version 1.0
 * @since   2019-09-28
 */
package org.apache.struts.user.action;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class ViewCreateAdmin extends ActionSupport implements SessionAware{
    private static final long serialVersionUID = 1;
    private String email;
    private String password;
    private String errorMessage;
    Map<String,Object> sessionmap;
    
    public String execute(){
    	
    	/**
    	 * Admin is able to access create admin page
    	 *  Validate the session by checking the email and access type. 
    	 *  return to login page if invalid session
    	 */
    	
    	if (sessionmap.containsKey("email")&&(sessionmap.containsKey("private"))) {
    		 return "SUCCESS";
    	 } else {
    		 return "LOGIN";
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