package org.apache.struts.user.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts.user.dao.UserManager;
import org.apache.struts.user.model.Receipient;
import org.apache.struts2.interceptor.SessionAware;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.mailer.config.TransportStrategy;

import com.opensymphony.xwork2.ActionSupport;

public class BulkMail extends ActionSupport implements SessionAware{
	private List<Receipient> receipients = null;
    private String receipientName;
    private String receipientEmail;
    private String msg;
    ResultSet rs = null;
	Mailer mailer;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() throws SQLException, Exception {
		
		receipients = new ArrayList<Receipient>();
		
		rs = UserManager.fetchRecipient();
		if (rs != null) {
			try {
				while (rs.next()) {
					Receipient receipient = new Receipient();
					receipient.setReceipientName(rs.getString("name"));
					receipient.setReceipientEmail(rs.getString("email"));
					receipients.add(receipient);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for (Receipient r : receipients) {
				Email email = EmailBuilder.startingBlank()
						.from("ABC Community Portal", "yhuang0021@gmail.com")
						//.to("Huang","iceboi1183@hotmail.com")
						.to(r.getReceipientName(), r.getReceipientEmail())
						.withSubject("Join Us")
						.withPlainText("Come Join ABC Community Portal")
						.buildEmail();
			
				mailer = MailerBuilder
						.withSMTPServer("smtp.gmail.com", 587, "youremail", "yourpassword")
						.withTransportStrategy(TransportStrategy.SMTP_TLS)
						.buildMailer();
	
				mailer.sendMail(email);
			}
			
			UserManager.truncateReceipient();
			
			msg = "Email Send Successfully";
			receipients = null;
		}
		return "success";
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		
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
	 * @return the mailer
	 */
	public Mailer getMailer() {
		return mailer;
	}

	/**
	 * @param mailer the mailer to set
	 */
	public void setMailer(Mailer mailer) {
		this.mailer = mailer;
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
	
}
