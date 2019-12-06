/**
 * User Search Profile Action class: Once invoked lets user search for other user 
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

public class SearchProfileAction extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	private String search;
	private ResultSet rs = null;
	private UserManager admin = null;
	private List<Profile> users = null;
	private String message = "";
	private int type;
	Map<String,Object> sessionmap;
	
	/**
	 * Users are able to search using first name, last name.
	 * Message will be shown if no results are returned in the search. 
	 */

	@Override
	public String execute() throws Exception {
		
		/**
    	 *  Validate the session by checking the email and access type. 
    	 */
    	
		if (sessionmap.containsKey("email")&&(sessionmap.containsKey("public"))) {
			
		if (search.equals(null) || search.equals("")) {
			message = "Input Search Details";
			return "HOME";
		}
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
					users.add(user);
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (users.size() == 0) {
			message = "No profiles found";
		} 
			return "SEARCHPROFILE";
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
	 * Get Session
	 */
	
	public Map<String, Object> getSessionmap() {
		return sessionmap;
	}
	
	/**
	 * Set Session
	 */
	
	public void setSession(Map<String, Object> session) {
		this.sessionmap = session;
		
	}
}
