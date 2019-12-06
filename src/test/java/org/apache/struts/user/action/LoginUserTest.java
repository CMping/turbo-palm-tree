package org.apache.struts.user.action;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginUserTest {
	LoginUser dao = new LoginUser();

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testExecute() {
		dao.setEmail("yhuang0021@gmail.com");
		dao.setPassword("123");
		try {
			assertEquals("SUCCESS",dao.execute());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		fail("Not yet implemented");
	}

}
