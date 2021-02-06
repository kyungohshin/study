package org.zerock.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

/**
 *
 *
 * @author USER
 * @history
 *          2020. 10. 2. initial creation
 */
public class MysqlConnectTest {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3307/testDB";

	@Test
	public void test() throws Exception {
		Class.forName(DRIVER);

		try (Connection con = DriverManager.getConnection(URL, "shin", "654654")) {
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
