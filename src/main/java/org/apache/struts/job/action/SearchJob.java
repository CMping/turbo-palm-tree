/**
 * User Search Job Action class: Once invoked lets user search for other user 
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

public class SearchJob extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	private int jobID;
	private String jobTittle;
	private String jobDetails;
	private String jobTimestamp;
	private int userID;
	private String firstName;
	private String search;
	private ResultSet rs = null;
	private JobManager admin = null;
	private List<Job> jobs = null;
	private String message = "";
	private int type;
	Map<String,Object> sessionmap;
	
	/**
	 * Users are able to search using first name, last name.
	 * Message will be shown if no results are returned in the search. 
	 */

	@Override
	public String execute() throws Exception {
		
		/**
    	 *  Validate the session by checking the email and access type. 
    	 */
    	
		if (sessionmap.containsKey("email")){
			
		setJobs(new ArrayList<Job>());
		
		try {
			admin = new JobManager();
			rs = admin.searchJob(search);
			if (rs != null) {
				while (rs.next()) {
					Job job = new Job(jobID, jobTittle, jobDetails, jobTimestamp, userID, firstName);
					job.setJobID(rs.getInt("job_id"));
					job.setJobTittle(rs.getString("job_tittle"));
					job.setJobTimestamp(rs.getString("job_timestamp"));
					job.setUserID(rs.getInt("user_id_fk"));
					job.setFirstName(rs.getString("first_name"));
					jobs.add(job);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (jobs.size() == 0) {
			message = "No job found";
		} 
			return "SEARCHJOB";
		} else { 
			return "LOGIN";
		}
	}	
	
	/**
	 * Get Message
	 */

	public String getMessage() {
		return message;
	}
	
	/**
	 * Set Message
	 */

	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Get Search 
	 */

	public String getSearch() {
		return search;
	}
	
	/**
	 * Set Search 
	 */

	public void setSearch(String search) {
		this.search = search;
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
	 * Get Session
	 */
	
	public Map<String, Object> getSessionmap() {
		return sessionmap;
	}
	
	/**
	 * Set Session
	 */
	
	public void setSession(Map<String, Object> session) {
		this.sessionmap = session;
		
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
}
