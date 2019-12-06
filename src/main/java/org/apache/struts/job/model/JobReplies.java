package org.apache.struts.job.model;

public class JobReplies {
	
	private int jrID;
	private String jrMessage;
	private String jrTimestamp;
	private int jobID;
	private int userID;
	private String replyerName;
	
	public JobReplies (int jrID, String jrMessage, String jrTimestamp, int jobID, int userID, String replyerName) {	
		setJrID(jrID);
		setJrMessage(jrMessage);
		setJrTimestamp(jrTimestamp);
		setJobID(jobID);
		setUserID(userID);
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
	
}
