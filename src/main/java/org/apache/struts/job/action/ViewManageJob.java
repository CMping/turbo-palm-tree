/**
 * User View Own Job Post Action class: Once invoked lets user to see all the job he posted 
 * 
 * @author Huang Yanping
 * @version 1.0
 * @since   2019-09-28
 */

package org.apache.struts.job.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.struts.job.dao.JobManager;
import org.apache.struts.job.model.Job;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class ViewManageJob extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private int jobID;
	private String jobTittle;
	private String jobDetails;
	private String jobTimestamp;
	private int userID;
	private String firstName;
	private ResultSet rs = null;
	private JobManager admin = null;
	private List<Job> jobs = null;
	private String message = "";
	Map<String,Object> sessionmap;
	
	/**
	 * User to see all the job he posted 
	 */
	
	@Override
	public String execute() throws Exception {
		
		/**
    	 *  Validate the session by checking the email and access type. 
    	 */
		
		if (sessionmap.containsKey("email")&&(sessionmap.containsKey("public"))) {
			
		jobs = new ArrayList<Job>();
		try {
			admin = new JobManager();
			rs = JobManager.myJob(userID);
			if (rs != null) {
				while (rs.next()) {
					Job job = new Job(jobID, jobTittle, jobDetails, jobTimestamp, userID, firstName);
					job.setJobID(rs.getInt("job_id"));
					job.setJobTittle(rs.getString("job_tittle"));
					job.setJobDetails(rs.getString("job_details"));
					job.setJobTimestamp(rs.getString("job_timestamp"));
					jobs.add(job);
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (jobs.size() == 0) {
			message = "No Job Posted";
		}
			return "MANAGEJOB";
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
	 * @return the admin
	 */
	public JobManager getAdmin() {
		return admin;
	}


	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(JobManager admin) {
		this.admin = admin;
	}


	/**
	 * @return the jobs
	 */
	public List<Job> getJobs() {
		return jobs;
	}


	/**
	 * @param jobs the jobs to set
	 */
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}


	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}


	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
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
