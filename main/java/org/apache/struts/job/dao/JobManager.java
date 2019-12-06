package org.apache.struts.job.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JobManager {
	
	/**
	 * get database connection method
	 */
	
    public static Connection getConnection() {
        Connection con = null;
        String db = "m5project";
        String user = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver"); // com.mysql.cj.jdbc.Driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db, user, "P@ssw0rd");
        }
        catch(SQLException e) {
            System.out.println("SQLException caught: " +e.getMessage());
        }
        return con;
    }
    
    /**
	 * Create job method
	 */
    
    public static int createJob(String jobTittle, String jobDetails, int userID) 
    		throws SQLException {
        Connection con = JobManager.getConnection();
        String sql = "insert into jobs(job_tittle, job_details, user_id_fk) values (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, jobTittle);
        ps.setString(2, jobDetails);
        ps.setInt(3, userID);
        int i = ps.executeUpdate();

        return i;
    }
    
    /**
	 * Create job reply method
	 */
    
    public static int createJobReply(String jrMessage, int jobID, int userID) 
    		throws SQLException {
        Connection con = JobManager.getConnection();
        String sql = "insert into job_replies(jr_message, job_id_fk, user_id_fk) values (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, jrMessage);
        ps.setInt(2, jobID);
        ps.setInt(3, userID);
        int i = ps.executeUpdate();

        return i;
    }
    
    public static ResultSet fetchJobReplies(int jobID) {
      	 Connection con = JobManager.getConnection();
           String sql = "select * from job_replies INNER JOIN users ON job_replies.user_id_fk = users.user_id WHERE job_id_fk = ?";
           PreparedStatement ps;
           ResultSet rs = null;
   		try {
   			ps = con.prepareStatement(sql);
   			ps.setInt(1, jobID);
   			rs = ps.executeQuery();
   			
   		} catch (SQLException e) {
   			e.printStackTrace();
   		}
   		return rs;	
       } 
    
	/**
	 * Search job method
	 */
    
    public ResultSet searchJob(String searchTerm) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM jobs INNER JOIN users ON jobs.user_id_fk = users.user_id WHERE job_tittle LIKE '%" + searchTerm + "%';";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
    
    /**
	 * View Job Details method
	 */
    
    public static ResultSet fetchJobDetails(int jobID) {
   	 Connection con = JobManager.getConnection();
        String sql = "select * from jobs INNER JOIN users ON jobs.user_id_fk = users.user_id WHERE job_id = ?";
        PreparedStatement ps;
        ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, jobID);
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;	
    } 
    
    public static ResultSet myJob(int userID) {
   	 Connection con = JobManager.getConnection();
        String sql = "select * from jobs where user_id_fk = ?";
        PreparedStatement ps;
        ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, userID);
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;	
   }
    public int updateJob(String jobTittle, String jobDetails, int jobID)
    		throws SQLException, Exception {
				
		int i = 0;
				
		try {	
			Connection connection = JobManager.getConnection();
				
			String sql = "UPDATE jobs SET job_tittle=?,job_details=? where job_id=?";
				
			PreparedStatement ps = connection.prepareStatement(sql);
				
			ps.setString(1, jobTittle);
			ps.setString(2, jobDetails);
			ps.setInt(3, jobID);
			
			i = ps.executeUpdate();
				
			return i;	
			} catch (Exception e) {
				e.printStackTrace();
				getConnection().rollback();
				return 0;
				
				} finally {
				if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
	/**
	 * Delete profile method
	 */
    
    public int deleteJob(int jobID)
			throws SQLException, Exception {
			
		int i = 0;
		
		try {	
			Connection connection = JobManager.getConnection();
			
			String sql = "DELETE FROM jobs WHERE job_id=?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, jobID);
			
			i = ps.executeUpdate();
			
			return i;
			
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return 0;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
}
