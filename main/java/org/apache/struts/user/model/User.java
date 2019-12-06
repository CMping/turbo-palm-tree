/**
 * User Java Bean Class 
 * 
 * @author Huang Yanping
 * @version 1.0
 * @since   2019-09-28
 */

package org.apache.struts.user.model;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String cPassword;
    private int type;

    public User (int id, String firstName, String lastName, String email,
    			String password, int type) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
        setType(type);
    }
	  
    /**
	 * Get FullName
	 */
    
    public String toString() {
        return this.getFirstName() + " " + this.getLastName();
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
	 * Get ConfirmPassword
	 */
    
	public String getcPassword() {
		return cPassword;
	}
	  
    /**
	 * Set ConfirmPassword
	 */
    
	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
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
    
	public void setType(int type) { // 0 = programmer , 1 = administrator
        if (type != 0) {
            type = 1;
        }
		this.type = type;
	}
}