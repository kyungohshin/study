package jpaStudy.dbTest;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 *
 * @author USER
 * @history
 *          2020. 10. 4. initial creation
 */
@RunWith(SpringJUnit4ClassRunner.class) // 이클래스의 테스트 코드를 돌릴때 스프링이 로딩되도록 하는부분.
@ContextConfiguration(locations = { "file:src/main/resources/*.xml" }) // 어느위치의 xml을
                                                                       // 읽어서 스프링을
                                                                       // 로딩하겠다.
public class DataSourceTest {

	@Autowired
	private DataSource ds;

	@Autowired
	private SqlSessionFactory sqlFactory;

	@Test
	public void testFactory() {
		System.out.println(sqlFactory);
	}

	@Test
	public void testSession() throws Exception {
		try (SqlSession session = sqlFactory.openSession()) {
			System.out.println(session);
		} catch (Exception e) {

		}
	}

	@Test
	public void testConnection() throws Exception {

		try (Connection con = ds.getConnection()) {
			System.out.println("@" + con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
