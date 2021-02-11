package jpaStudy;

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
public class H2ConnectTest {
	private static final String DRIVER = "org.h2.Driver";
	private static final String URL = "jdbc:h2:tcp://localhost/~/test";

	@Test
	public void test() throws Exception {
		Class.forName(DRIVER);

		try (Connection con = DriverManager.getConnection(URL, "sa", "")) {
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
