package org.apache.struts.user.model;

public class Receipient {
    private int receipientId;
    private String setter;
    private String receipientName;
    private String receipientEmail;
    
    
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
	/**
	 * @return the setter
	 */
	public String getSetter() {
		return setter;
	}
	/**
	 * @param setter the setter to set
	 */
	public void setSetter(String setter) {
		this.setter = setter;
	}

}
