/**
 * Admin Delete Profile Action class: Once invoked lets admin delete user profile 
 * 
 * @author Huang Yanping
 * @version 1.0
 * @since   2019-09-28
 */

package org.apache.struts.job.action;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts.job.dao.JobManager;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class DeleteJob extends ActionSupport implements SessionAware{
    private static final long serialVersionUID = 1;  
    private int jobID;
	private String jobTittle;
	private String jobDetails;
	private String jobTimestamp;
	private int userID;
    public String submitType;
    private String msg;
    ResultSet rs = null;
    Map<String,Object> sessionmap;
    JobManager dao = new JobManager();
   
   /**
    * Delete Job Action method
    */

    public String execute() throws SQLException {
    	
    	/**
    	 *  Validate the session by checking the email and access type. 
    	 */
    	
    	if (sessionmap.containsKey("email")) {
    		
    	try {
    		if (submitType.equals("fetchDetails")) {		
				rs = JobManager.fetchJobDetails(jobID);
				
				if (rs != null) {
					while (rs.next()) {
						jobTittle = rs.getString("job_tittle");
						jobDetails = rs.getString("job_details");
						jobTimestamp = rs.getString("job_timestamp");
					}
				}   		 
    		 } else {
    			int ctr = dao.deleteJob(jobID);
    				jobID = 0;
    				jobTittle = null;
    				jobDetails = null;
    				jobTimestamp = null;
    				userID = 0;
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
	 * @return the jobID
	 */
	public int getJobID() {
		return jobID;
	}
	
	
	/**
	 * @param jobID the jobID to set
	 */
	public void setJobID(int jobID) {
		this.jobID = jobID;
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
	 * @return the jobTimestamp
	 */
	public String getJobTimestamp() {
		return jobTimestamp;
	}
	
	
	/**
	 * @param jobTimestamp the jobTimestamp to set
	 */
	public void setJobTimestamp(String jobTimestamp) {
		this.jobTimestamp = jobTimestamp;
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
	 * @return the submitType
	 */
	public String getSubmitType() {
		return submitType;
	}
	
	
	/**
	 * @param submitType the submitType to set
	 */
	public void setSubmitType(String submitType) {
		this.submitType = submitType;
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
