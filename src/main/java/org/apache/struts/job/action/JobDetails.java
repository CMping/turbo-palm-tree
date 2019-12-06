/**
 * View Job Details Action class: Once invoked lets user to view other user job.
 * 
 * @author Huang Yanping
 * @version 1.0
 * @since   2019-09-28
 */

package org.apache.struts.job.action;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts.job.dao.JobManager;
import org.apache.struts.job.model.JobReplies;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JobDetails extends ActionSupport implements SessionAware{
    private static final long serialVersionUID = 1;
    private int jobID;
    private String jobTittle;
	private String jobDetails;
	private String jobTimestamp;
	private int userID;
	private int jrID;
	private String jrMessage;
	private String jrTimestamp;
	private String replyerName;
	private String firstName;
	private String lastName;
	private List<JobReplies> replies = null;
    Map<String,Object> sessionmap;
    JobManager dao = new JobManager();
    
	/**
	 * User are able to view job details
	 */
    
    public String execute() throws SQLException {
    	
    	/**
    	 *  Validate the session by checking the email 
    	 *  return to login page if there is no session
    	 *  return to job detail page if successful
    	 */	
    	
    	if (sessionmap.containsKey("email")) {
    	
    	ResultSet rs = JobManager.fetchJobDetails(jobID);
    	
    	if (rs != null) {
			while (rs.next()) {
				jobTittle = rs.getString("job_tittle");
				jobDetails = rs.getString("job_details");
				jobTimestamp = rs.getString("job_timestamp");
				firstName = rs.getString("first_name");
				lastName = rs.getString("last_name");
				jobID = rs.getInt("job_id");
				}
			
		replies = new ArrayList<JobReplies>();
		ResultSet jrrs = JobManager.fetchJobReplies(jobID);
			
		if (jrrs != null) {
			while (jrrs.next()) {
				JobReplies reply = new JobReplies(jrID, jrMessage, jrTimestamp, jobID, userID, replyerName);
				reply.setJrID(jrrs.getInt("jr_id"));
				reply.setJrMessage(jrrs.getString("jr_message"));
				reply.setJrTimestamp(jrrs.getString("jr_timestmap"));
				reply.setJobID(jrrs.getInt("job_id_fk"));
				reply.setUserID(jrrs.getInt("user_id_fk"));
				reply.setReplyerName(jrrs.getString("first_name"));
				replies.add(reply);
				}
			return "JOB";
			}
	    }
		    } else {
		    	return "LOGIN";
    	}
    	return "JOB";
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
	 * @return the jrID
	 */
	public int getJrID() {
		return jrID;
	}

	/**
	 * @param jrID the jrID to set
	 */
	public void setJrID(int jrID) {
		this.jrID = jrID;
	}

	/**
	 * @return the jrMessage
	 */
	public String getJrMessage() {
		return jrMessage;
	}

	/**
	 * @param jrMessage the jrMessage to set
	 */
	public void setJrMessage(String jrMessage) {
		this.jrMessage = jrMessage;
	}

	/**
	 * @return the jrTimestamp
	 */
	public String getJrTimestamp() {
		return jrTimestamp;
	}

	/**
	 * @param jrTimestamp the jrTimestamp to set
	 */
	public void setJrTimestamp(String jrTimestamp) {
		this.jrTimestamp = jrTimestamp;
	}

	/**
	 * @return the replies
	 */
	public List<JobReplies> getReplies() {
		return replies;
	}

	/**
	 * @param replies the replies to set
	 */
	public void setReplies(List<JobReplies> replies) {
		this.replies = replies;
	}

	/**
	 * @return the replyerName
	 */
	public String getReplyerName() {
		return replyerName;
	}

	/**
	 * @param replyerName the replyerName to set
	 */
	public void setReplyerName(String replyerName) {
		this.replyerName = replyerName;
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