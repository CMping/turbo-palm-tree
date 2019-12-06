/**
 * User Create Job Action class: Once invoked lets User post an job opportunity 
 * 
 * @author Huang Yanping
 * @version 1.0
 * @since   2019-09-28
 */

package org.apache.struts.job.action;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts.job.dao.JobManager;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.util.Map;

public class CreateJob extends ActionSupport implements SessionAware{
    private static final long serialVersionUID = 1;
    	
    private String jobTittle;
    private String jobDetails;
    private int userID; 
    private String msg;
    Map<String,Object> sessionmap;
    
    /**
	 * User are able to post an job opportunity
	 */
    
     public String execute() throws SQLException {
    	 
    	 /**
     	 *  Validate the session by checking the email and access type. 
     	 */
    	 
    	if (sessionmap.containsKey("email")&&(sessionmap.containsKey("public"))) {
    		
    		if ((getJobTittle().length() == 0)||(getJobDetails().length() == 0)) {
				msg = "Job Title and Job Details cannot be empty";
				return SUCCESS;
				}
    		
	    	int ctr = JobManager.createJob(jobTittle, jobDetails, userID);
		    	if (ctr > 0) {
					msg = "Job Posted Successfuly";
					} else {
						msg = "error";
					}
		    		return SUCCESS;
		    	} else {
		    		return "LOGIN";
		    	}
    }
    

     /**
	 * @return the jobTittle
	 */
	public String getJobTittle() {
		return jobTittle;
	}

	/**
	 * @param jobTittle the jobTittle to set
	 */
	public void setJobTittle(String jobTittle) {
		this.jobTittle = jobTittle;
	}

	/**
	 * @return the jobDetails
	 */
	public String getJobDetails() {
		return jobDetails;
	}

	/**
	 * @param jobDetails the jobDetails to set
	 */
	public void setJobDetails(String jobDetails) {
		this.jobDetails = jobDetails;
	}

	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
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
}