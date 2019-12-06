/**
 * UserManager Java class: connects to the database to store and retrieve information for all pages. 
 * 
 * @author Huang Yanping
 * @version 1.0
 * @since   2019-09-28
 */

package org.apache.struts.user.dao;

import java.math.BigInteger;
import java.security.*;
import java.sql.*;

/**
 * UserManager method
 */

public class UserManager {
	
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
	 * Create user account method
	 */
    
    public static int createUser(String firstName, String lastName, String email, String password, int type) 
    		throws SQLException {
        Connection con = UserManager.getConnection();
        String sql = "insert into users(first_name, last_name, email, password, type) values (?, ?, ?, md5(?), ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, firstName);
        ps.setString(2, lastName);
        ps.setString(3, email);
        ps.setString(4, password);
        ps.setInt(5, type);
        int i = ps.executeUpdate();

        return i;
    }
    
	/**
	 * Create admin account method
	 */
    
    public static int createAdmin(String firstName, String lastName, String email, String password, int type) 
    		throws SQLException {
        Connection con = UserManager.getConnection();
        String sql = "insert into users(first_name, last_name, email, password, type) values (?, ?, ?, md5(?), ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, firstName);
        ps.setString(2, lastName);
        ps.setString(3, email);
        ps.setString(4, password);
        ps.setInt(5, 1);
        int i = ps.executeUpdate();

        return i;
    }    
    
	/**
	 * checking whether email is registered in the database method
	 */
    
    public static boolean emailExists(String email) throws SQLException {
        Connection con = UserManager.getConnection();
        String sql = "select user_id from users where email = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            return true;
        }
        return false;
    }
    
	/**
	 * Login method
	 */
    
    public static boolean login(String email, String password) throws SQLException {
        Connection con = UserManager.getConnection();
        String sql = "select * from users where email = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        
        String dbpassword = null;

        while (rs.next()) {
            dbpassword = rs.getString("password");
            System.out.println(dbpassword);
        }
        
        String encryptPassword = getMd5(password);
        
        if (encryptPassword.equals(dbpassword)) {
            return true;
        } else {
        	return false;
        }
    }
    
	/**
	 * Get profile details method
	 */
    
    public static ResultSet fetchDetails(String email) {
    	 Connection con = UserManager.getConnection();
         String sql = "select * from users where email = ?";
         PreparedStatement ps;
         ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;	
    }
    
    /**
	 * Update profile details method
	 */
    
    public int updateProfile(String firstName, String lastName, String companyName, String country,
    						 String city, String phone, String workExperience, String education,
    						 String skills, String hobbies, String email)
			throws SQLException, Exception {
			
		int i = 0;
		
		try {	
			Connection connection = UserManager.getConnection();
			
			String sql = "UPDATE users SET first_name=?,last_name=?,company_name=?,country=?,"
					+ "city=?,phone=?,work_experience=?,education=?,"
					+ "skills=?,hobbies=? where email=?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, companyName);
			ps.setString(4, country);
			ps.setString(5, city);
			ps.setString(6, phone);
			ps.setString(7, workExperience);
			ps.setString(8, education);
			ps.setString(9, skills);
			ps.setString(10, hobbies);
			ps.setString(11, email);
				
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
    
    public int deleteProfile(int id)
			throws SQLException, Exception {
			
		int i = 0;
		
		try {	
			Connection connection = UserManager.getConnection();
			
			String sql = "DELETE FROM users WHERE user_id=?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, id);
			
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
	 * Search profile method
	 */
    
    public ResultSet searchProfile(String searchTerm) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM users WHERE type=0 AND (first_name LIKE '%" + searchTerm + "%' OR last_name LIKE '%" + searchTerm + "%');";
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
	 * View public profile method
	 */
    
    public ResultSet fetchPublicDetails(int id) {
   	 Connection con = UserManager.getConnection();
        String sql = "select * from users where user_id = ?";
        PreparedStatement ps;
        ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;	
   } 
   
    /**
	 * Add receipient for bulk email method
	 */
    
    public static int addRecipient(String name, String email) 
			   throws SQLException {
	       Connection con = UserManager.getConnection();
	       String sql = "insert into receipient(name, email) values (?, ?)";
	       PreparedStatement ps = con.prepareStatement(sql);
	       ps.setString(1, name);
	       ps.setString(2, email);
	       int i = ps.executeUpdate();
	       
	       return i;
	    }
    
    /**
	 * Fetch receipient details for bulk email method
	 */
    
   public static ResultSet fetchRecipient() {
	   	 Connection con = UserManager.getConnection();
	        String sql = "select * from receipient";
	        PreparedStatement ps;
	        ResultSet rs = null;
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rs;	
	   }
   
   /**
	 * Delete receipient details for bulk email method
	 */
   
   public static int deleteReceipient(int id)
			throws SQLException, Exception {
			
		int i = 0;
		
		try {	
			Connection connection = UserManager.getConnection();
			
			String sql = "DELETE FROM receipient WHERE receipient_id=?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, id);
			
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
   
   public static int truncateReceipient()
			throws SQLException, Exception {
	   
	   int i = 0;
	   
	   try {	
			Connection connection = UserManager.getConnection();
			
			String sql = "TRUNCATE `m5project`.`receipient`;";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
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
	 * Encrypt the input string method
	 */
    
     public static String getMd5(String input) {
   	  	try {
    	  // Static getInstance method is called with hashing MD5 
             MessageDigest md = MessageDigest.getInstance("MD5"); 
    
          // digest() method is called to calculate message digest 
          //  of an input digest() return array of byte 
             byte[] messageDigest = md.digest(input.getBytes()); 
    
          // Convert byte array into signum representation 
             BigInteger no = new BigInteger(1, messageDigest); 
    
          // Convert message digest into hex value 
             String hashtext = no.toString(16); 
             while (hashtext.length() < 32) { 
            	 hashtext = "0" + hashtext; 
             } 
             return hashtext; 
         }  
    
          // For specifying wrong message digest algorithms 
          catch (NoSuchAlgorithmException e) { 
              throw new RuntimeException(e); 
          } 
      }             
}