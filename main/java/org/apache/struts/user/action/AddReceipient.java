/**
 * Admin Add ReceipientAction class: Once invoked lets Admin add another receipient
 * 
 * @author Huang Yanping
 * @version 1.0
 * @since   2019-09-28
 */

package org.apache.struts.user.action;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts.user.dao.UserManager;
import org.apache.struts.user.model.Receipient;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class AddReceipient extends ActionSupport implements SessionAware{
    private static final long serialVersionUID = 1;
    private String name;
    private String email;
    ResultSet rs = null;
    private List<Receipient> receipients = null;
    private int receipientId;
    private String receipientName;
    private String receipientEmail;
    private String msg;
    Map<String,Object> sessionmap;
    
    /**
	 * Admin are able to add another receipient
	 */
    
     public String execute() throws SQLException {
    	 
    	 /**
     	 *  Validate the session by checking the email and access type. 
     	 */
    	 
    	if (sessionmap.containsKey("email")&&(sessionmap.containsKey("private"))) {

    		if (getName().length() == 0) {
    			setMsg("Input Name,Name is Required");
    			receipients = new ArrayList<Receipient>();
    			
    			rs = UserManager.fetchRecipient();
    			if (rs != null) {
    				while (rs.next()) {
    					Receipient receipient = new Receipient();
    					receipient.setReceipientId(rs.getInt("receipient_id"));
    					receipient.setReceipientName(rs.getString("name"));
    					receipient.setReceipientEmail(rs.getString("email"));
    					receipients.add(receipient);
    				}
    			} return "FAILURE";
    		}
    		else if (getEmail().length() == 0) {
    			System.out.println("In Email Error");
        		setMsg("Input Email, Email is Required");
    			receipients = new ArrayList<Receipient>();
    			
    			rs = UserManager.fetchRecipient();
    			if (rs != null) {
    				while (rs.next()) {
    					Receipient receipient = new Receipient();
    					receipient.setReceipientId(rs.getInt("receipient_id"));
    					receipient.setReceipientName(rs.getString("name"));
    					receipient.setReceipientEmail(rs.getString("email"));
    					receipients.add(receipient);
    				}
    			}
        		return "FAILURE";
    			}
    		else if (validEmail(getEmail())==false)  {
    			setMsg("Invalid Email");
    			receipients = new ArrayList<Receipient>();
    			
    			rs = UserManager.fetchRecipient();
    			if (rs != null) {
    				while (rs.next()) {
    					Receipient receipient = new Receipient();
    					receipient.setReceipientId(rs.getInt("receipient_id"));
    					receipient.setReceipientName(rs.getString("name"));
    					receipient.setReceipientEmail(rs.getString("email"));
    					receipients.add(receipient);
    				}
    			}
        		return "FAILURE";
    			}
    		else {
    			int ctr = UserManager.addRecipient(name, email);
    	    	if (ctr > 0) {
    				msg = "Receipient Added Successfully";
    			
    			receipients = new ArrayList<Receipient>();
    			
    			rs = UserManager.fetchRecipient();
    			if (rs != null) {
    				while (rs.next()) {
    					Receipient receipient = new Receipient();
    					receipient.setReceipientId(rs.getInt("receipient_id"));
    					receipient.setReceipientName(rs.getString("name"));
    					receipient.setReceipientEmail(rs.getString("email"));
    					receipients.add(receipient);
    				}
    				} else {
    					msg = "error";
    				}
    	    		return "success";
    		}
    	}
    		 } else {
    			System.out.println("LOGIN !!!");
    			return "LOGIN";
    	}
		return "success";
     }
     
    /**
 	 * Validations for Email.
 	 * Making sure the email input follows the the regular expression
 	 */
    
    private boolean validEmail(String email2) {
		// TODO Auto-generated method stub
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$";                
        Pattern pat = Pattern.compile(emailRegex); 
        return pat.matcher(email2).matches(); 
    }
    
    
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the rs
	 */
	public ResultSet getRs() {
		return rs;
	}

	/**
	 * @param rs the rs to set
	 */
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	/**
	 * @return the receipients
	 */
	public List<Receipient> getReceipients() {
		return receipients;
	}

	/**
	 * @param receipients the receipients to set
	 */
	public void setReceipients(List<Receipient> receipients) {
		this.receipients = receipients;
	}

	/**
	 * @return the receipientId
	 */
	public int getReceipientId() {
		return receipientId;
	}

	/**
	 * @param receipientId the receipientId to set
	 */
	public void setReceipientId(int receipientId) {
		this.receipientId = receipientId;
	}

	/**
	 * @return the receipientName
	 */
	public String getReceipientName() {
		return receipientName;
	}

	/**
	 * @param receipientName the receipientName to set
	 */
	public void setReceipientName(String receipientName) {
		this.receipientName = receipientName;
	}

	/**
	 * @return the receipientEmail
	 */
	public String getReceipientEmail() {
		return receipientEmail;
	}

	/**
	 * @param receipientEmail the receipientEmail to set
	 */
	public void setReceipientEmail(String receipientEmail) {
		this.receipientEmail = receipientEmail;
	}
	
}