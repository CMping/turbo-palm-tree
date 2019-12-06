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

public class SiteMap extends ActionSupport implements SessionAware{
    private static final long serialVersionUID = 1;
    private String email;
    Map<String,Object> sessionmap;
    
    public String execute(){
    	
    	/**
    	 * Admin is able to access create admin page
    	 *  Validate the session by checking the email and access type. 
    	 *  return to login page if invalid session
    	 */
    	
    	if(sessionmap.containsKey("private")) {
    		 return "ADMIN";
    		 
    	 } else if(sessionmap.containsKey("public")){
    		 return "USER";
    		 
    	 } else { 	
    		 return "PUBLIC";
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