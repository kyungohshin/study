package org.zerock.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.dao.MemberDAO;
import org.zerock.domain.MemberVO;

/**
 *
 *
 * @author USER
 * @history
 *          2020. 10. 11. initial creation
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class MemberDAOTest {

	@Autowired
	private MemberDAO dao;

	@Before
	public void setup() {

	}

	@Test
	public void testTime() throws Exception {
		System.out.println(dao.getTime());
	}

	@Test
	public void testInsertMember() throws Exception {
		MemberVO vo = new MemberVO();
		vo.setUserid("userid");
		vo.setUserpw("userpw");
		vo.setUsername("username");
		vo.setEmail("email");

		dao.insertMember(vo);
	}

	@Test
	public void testReadMember() throws Exception {
		dao.readMember("userid");
	}

	@Test
	public void testReadWithPW() throws Exception {

		dao.readWithPW("userid", "userpw");
	}
}
