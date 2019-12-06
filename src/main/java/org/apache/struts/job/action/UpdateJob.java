/**
 * Admin Update Profile Action class: Once invoked lets Admin update user profile 
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

public class UpdateJob extends ActionSupport implements SessionAware{
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
	 * Admin are able to update user profile
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
    			if ((getJobTittle().length() == 0)||(getJobDetails().length() == 0)) {
    				msg = "Job Title and Job Details cannot be empty";
    				return "UPDATE";
    				}
    			int ctr = dao.updateJob(jobTittle, jobDetails, jobID);
    			
    				if (ctr > 0) {
    					msg = "Record Updated Successfuly";
    					} else {
    						msg = "error";
    					}
    			}
    		}
	    	catch (Exception e) {
			e.printStackTrace();
	    		}
	    	return "UPDATE";
    	}
			return "FAILURE";
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
		// TODO Auto-generated method stub
		this.sessionmap = session;	
	}	
}
