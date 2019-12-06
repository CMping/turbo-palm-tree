/**
 * Profile Java Bean Class 
 * 
 * @author Huang Yanping
 * @version 1.0
 * @since   2019-09-28
 */

package org.apache.struts.user.model;

public class Profile {
	
	int id;
	String firstName, lastName, companyName, country, 
	city,  phone,  workExperience,  education,
	skills,  hobbies,  email;
	  
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
}
