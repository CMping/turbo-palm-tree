/**
 * Login Action class: Once invoked lets admin or user to login
 * 
 * @author Huang Yanping
 * @version 1.0
 * @since   2019-09-28
 */

package org.apache.struts.user.action;

import org.apache.struts.user.dao.UserManager;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class LoginUser extends ActionSupport implements SessionAware{
    private static final long serialVersionUID = 1;
    private int type;
    private int id;
    private String email;
    private String password;
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
    private String errorMessage;
    Map<String,Object> sessionmap;
    
    /**
	 * User and admin are able to login and access the website respective functionality
	 */
    
    public String execute() throws SQLException{
    	
    	   /**
    	    * Validate whether the email is registered 
    	    * if not registered
    	    * return to login page with error message "Email not registered yet"
    	    */
    	
        if (!UserManager.emailExists(email)) {
        	System.out.println(email);
            setErrorMessage("Email not registered yet");
            return "FAILURE";
        }
        
        /**
 	    * Validate whether the email and the password matches
 	    * if not 
 	    * return to login page with error message "Password incorrect"
 	    * if matches direct to homepage base on the type where type 0 = user and type 1 = admin
 	    */
        
        boolean login = UserManager.login(email, password);
        if (login) {
        	ResultSet rs = UserManager.fetchDetails(email);
        	type = 0;
        	id = 0;
        	firstName = "";
        	lastName = "";
        	companyName = "";
        	country = "";
        	city = "";
        	phone = "";
        	workExperience = "";
        	education = "";
        	skills = "";    
        	hobbies = "";

        	
        	while(rs.next()){
        		id = rs.getInt("user_id");
        		firstName = rs.getString("first_name");
        		lastName = rs.getString("last_name"); 
        		type = rs.getInt("type"); 	
        		password = rs.getString("password");
        		companyName = rs.getString("company_name");
        		country = rs.getString("country");
        		city = rs.getString("city");
        		phone = rs.getString("phone");
        		workExperience = rs.getString("work_experience");
        		education = rs.getString("education");
        		skills = rs.getString("skills");
        		hobbies = rs.getString("hobbies");
        		
        		sessionmap.put("id", id);
        		sessionmap.put("email", email);
        	}
        	
        	if(type==0) {
        		sessionmap.put("public", 0);
        		type = 0;
        		return "SUCCESS";
        	}
            else {
            	type = 1;
            	sessionmap.put("private", 1);
            	return "ADMINSUCCESS";
            }
        } else {
        	setErrorMessage("Password incorrect");
            return "FAILURE";
        }
    }
    public String logout() {
    	
        /**
 	    * Remove the session to prevent unauthorised access
 	    */
    	
        if (sessionmap.containsKey("email")) {
            sessionmap.remove("private");
            sessionmap.remove("public");
        }
        return "SUCCESS";
    }

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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