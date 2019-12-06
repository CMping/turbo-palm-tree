/**
 * View Public Profile Action class: Once invoked lets user to view other user profile.
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class PublicProfile extends ActionSupport implements SessionAware{
    private static final long serialVersionUID = 1;
    private User user;	
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int type; 
    Map<String,Object> sessionmap;
    UserManager dao = new UserManager();
    
	/**
	 * User are able to view other user profile
	 */
    
    public String execute() throws SQLException {
    	
    	/**
    	 *  Validate the session by checking the email and access type. 
    	 *  return to login page if there is no session
    	 *  return to public profile page if successful
    	 */	
    	
    	if (sessionmap.containsKey("email")&&(sessionmap.containsKey("public"))) {
    	
    	ResultSet rs = dao.fetchPublicDetails(id);
    	if (rs != null) {
			while (rs.next()) {
				firstName = rs.getString("first_name");
				lastName = rs.getString("last_name");
				email = rs.getString("email");
			}
			return "Profile";
    	} else {
    		return "failure";
    	}
    	} else {
    		return "LOGIN";
    	}
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
	 * Get Id
	 */

    public int getId() {
		return id;
	}
    
	/**
	 * Set Id
	 */

	public void setId(int id) {
		this.id = id;
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