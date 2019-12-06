/**
 * Admin Search Profile Action class: Once invoked lets admin search user profile 
 * 
 * @author Huang Yanping
 * @version 1.0
 * @since   2019-09-28
 */

package org.apache.struts.user.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.struts.user.dao.UserManager;
import org.apache.struts.user.model.Profile;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class AdminSearch extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private String search;
	private ResultSet rs = null;
	private UserManager admin = null;
	private List<Profile> users = null;
	private String message = "";
	Map<String,Object> sessionmap;
	
	/**
	 * Admin are able to search user using first name and last name 
	 * All will be shown if no input in the search. 
	 */
	
	@Override
	public String execute() throws Exception {
		
		/**
    	 *  Validate the session by checking the email and access type. 
    	 */
		
		if (sessionmap.containsKey("email")&&(sessionmap.containsKey("private"))) {
			
		users = new ArrayList<Profile>();
		
		try {
			admin = new UserManager();
			rs = admin.searchProfile(search);
			if (rs != null) {
				while (rs.next()) {
					Profile user = new Profile();
					user.setId(rs.getInt("user_id"));
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setEmail(rs.getString("email"));
					users.add(user);
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (users.size() == 0) {
			message = "No profiles found";
		}
			return "ADMINSEARCHPROFILE";
		} else {
			return "LOGIN";
		}
	}
	
	/**
	 * Get Message
	 */

	public String getMessage() {
		return message;
	}
	
	/**
	 * Set Message
	 */

	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Get Search 
	 */

	public String getSearch() {
		return search;
	}
	
	/**
	 * Set Search 
	 */

	public void setSearch(String search) {
		this.search = search;
	}
	
	/**
	 * Get Users
	 */

	public List<Profile> getUsers() {
		return users;
	}
	
	/**
	 * Set Users
	 */

	public void setUsers(List<Profile> users) {
		this.users = users;
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
		// TODO Auto-generated method stub
		this.sessionmap = session;		
	}	
}
