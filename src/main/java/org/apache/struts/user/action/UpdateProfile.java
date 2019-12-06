/**
 * User Update Profile Action class: Once invoked lets user search for other user 
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

public class UpdateProfile extends ActionSupport implements SessionAware{
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
    ResultSet rs = null;
    public String submitType;
    Map<String,Object> sessionmap;
    UserManager dao = new UserManager();
    
    /**
	 * Users are able to update their profile
	 */

    public String execute() throws SQLException {
    	
    	/**
    	 *  Validate the session by checking the email and access type. 
    	 *  return to login page if invalid session
    	 */
    	
    	if (sessionmap.containsKey("email")&&(sessionmap.containsKey("public"))) {
    		
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
					}
				}
    		} else {   			
    			System.out.println(submitType + "  " + email);
    			
    			if (getFirstName().length() == 0) {
    				msg = "First Name cannot be empty";
    				return "UPDATE";
    				
    			} else {
    				
    			int ctr = dao.updateProfile(firstName, lastName, companyName, country, 
    					city, phone, workExperience, education,
    					skills, hobbies, email);
    			
    			sessionmap.put("email", email);
     		
    				if (ctr > 0) {
    					msg = "Record Updated Successfuly";
    					} else {
    						msg = "error";
    					}
    				}
    			}
    		}		
    	catch (Exception e) {
		e.printStackTrace();
	}
    	return "UPDATE";
    }
		return "LOGIN";
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
	 * Get Message
	 */

	public String getMsg() {
		return msg;
	}
	
	/**
	 * Set Message
	 */

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	/**
	 * Get ResultSet rs
	 */

	public ResultSet getRs() {
		return rs;
	}
	
	/**
	 * Set ResultSet rs
	 */

	public void setRs(ResultSet rs) {
		this.rs = rs;
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
	/**
	 * Get CompanyName
	 */

    public String getCompanyName() {
		return companyName;
	}
	  
    /**
	 * Set CompanyName
	 */

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	  
    /**
	 * Get Country
	 */

	public String getCountry() {
		return country;
	}
	  
    /**
	 * Set Country
	 */

	public void setCountry(String country) {
		this.country = country;
	}
	  
    /**
	 * Get City
	 */

	public String getCity() {
		return city;
	}
	  
    /**
	 * Set City
	 */

	public void setCity(String city) {
		this.city = city;
	}
	  
    /**
	 * Get Phone
	 */

	public String getPhone() {
		return phone;
	}
	  
    /**
	 * Set Phone
	 */

	public void setPhone(String phone) {
		this.phone = phone;
	}
	  
    /**
	 * Get WorkExperience
	 */

	public String getWorkExperience() {
		return workExperience;
	}
	  
    /**
	 * Set WorkExperience
	 */

	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}
	  
    /**
	 * Get Education
	 */

	public String getEducation() {
		return education;
	}
	  
    /**
	 * Set Education
	 */

	public void setEducation(String education) {
		this.education = education;
	}
	  
    /**
	 * Get SKills
	 */

	public String getSkills() {
		return skills;
	}
	  
    /**
	 * Set Skills
	 */

	public void setSkills(String skills) {
		this.skills = skills;
	}
	  
    /**
	 * Get Hobbies
	 */

	public String getHobbies() {
		return hobbies;
	}
	  
    /**
	 * Set Hobbies
	 */

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
}
