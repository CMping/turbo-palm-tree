/**
 * Admin Delete Profile Action class: Once invoked lets admin delete user profile 
 * 
 * @author Huang Yanping
 * @version 1.0
 * @since   2019-09-28
 */

package org.apache.struts.user.action;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts.user.dao.UserManager;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class AdminDelete extends ActionSupport implements SessionAware{
    private static final long serialVersionUID = 1;  
    private int id;
    private int type;
    private String firstName;
    private String lastName;
    private String companyName;
    private String country;
    private String city;
    private String phone;
    private String workExperience;
    private String education;
    private String skills;
    private String hobbies;
    private String email;
    private String msg;
    public String submitType;
    ResultSet rs = null;   
    Map<String,Object> sessionmap;
    UserManager dao = new UserManager();
   
   /**
    * Delete Profile Action method
    */

    public String execute() throws SQLException {
    	
    	/**
    	 *  Validate the session by checking the email and access type. 
    	 */
    	
    	if (sessionmap.containsKey("email")&&(sessionmap.containsKey("private"))) {
    		
    	try {
    		if (submitType.equals("fetchProfile")) {		
				rs = UserManager.fetchDetails(email);
				if (rs != null) {
					while (rs.next()) {
						firstName = rs.getString("first_name");
						lastName = rs.getString("last_name");
						companyName = rs.getString("company_name");
						country = rs.getString("country");
						city = rs.getString("city");
						phone = rs.getString("phone");
						workExperience = rs.getString("work_experience");
						education = rs.getString("education");
						skills = rs.getString("skills");
						hobbies = rs.getString("hobbies");
						id = rs.getInt("user_id");
					}
				}   		 
    		 } else {
    			System.out.println(id);
    			int ctr = dao.deleteProfile(id);
    				firstName = null;
    				lastName = null;
    				companyName = null;
    				country = null;
    				city = null;
    				phone = null;
    				workExperience = null;
    				education = null;
    				skills = null;
    				hobbies = null;
    				if (ctr > 0) {
    					msg = "Record Deleted Successfuly";
    					} else {
    						msg = "error";
    					}
    		}
    	} 
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    		return "DELETE";
    	} else {
    		return "LOGIN";
    	}
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
	 * Get ResultSet
	 */

	public ResultSet getRs() {
		return rs;
	}
	
    /**
	 * Set ResultSet
	 */

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

    /**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the workExperience
	 */
	public String getWorkExperience() {
		return workExperience;
	}

	/**
	 * @param workExperience the workExperience to set
	 */
	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}

	/**
	 * @return the education
	 */
	public String getEducation() {
		return education;
	}

	/**
	 * @param education the education to set
	 */
	public void setEducation(String education) {
		this.education = education;
	}

	/**
	 * @return the skills
	 */
	public String getSkills() {
		return skills;
	}

	/**
	 * @param skills the skills to set
	 */
	public void setSkills(String skills) {
		this.skills = skills;
	}

	/**
	 * @return the hobbies
	 */
	public String getHobbies() {
		return hobbies;
	}

	/**
	 * @param hobbies the hobbies to set
	 */
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
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
