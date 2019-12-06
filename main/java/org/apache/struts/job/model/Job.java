/**
 * Job Java Bean Class 
 * 
 * @author Huang Yanping
 * @version 1.0
 * @since   2019-09-28
 */

package org.apache.struts.job.model;

public class Job {
	
	private int jobID;
	private String jobTittle;
	private String jobDetails;
	private String jobTimestamp;
	private int userID;
	private String firstName;
	
	public Job (int jobID, String jobTittle, String jobDetails, String jobTimestamp, int userID, String firstName) {	
		setJobID(jobID);
		setJobTittle(jobTittle);
		setJobDetails(jobDetails);
		setJobDetails(jobTimestamp);
		setUserID(userID);
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
}
