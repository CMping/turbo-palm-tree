/**
 * User view job page Action class: Once invoked lets user to go view own profile page
 * 
 * @author Huang Yanping
 * @version 1.0
 * @since   2019-09-28
 */

package org.apache.struts.job.action;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

public class ViewJob extends ActionSupport implements SessionAware{
    private static final long serialVersionUID = 1;
    private String email;
    Map<String,Object> sessionmap;
    
	/**
	 * User is able to access job page
	 * Validate the session by checking the email and access type. 
	 * return to login page if invalid session
	 */
    
    public String execute(){
    	
    	if (sessionmap.containsKey("email")&&(sessionmap.containsKey("public"))) {
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