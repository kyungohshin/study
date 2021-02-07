package jpaStudy.dbTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.MemberDao;
import dto.Member;

/**
 *
 *
 * @author USER
 * @history
 *          2020. 10. 11. initial creation
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/*.xml" })
public class MemberDaoTest {

	@Autowired
	private MemberDao dao;

	@Before
	public void setup() {

	}

//	@Test
	public void testInsertMember() throws Exception {
		Member vo = new Member();
		vo.setId(5);
		vo.setAge(29);
		vo.setTeam_id(2);
		vo.setUserName("shin");

		dao.insertMember(vo);
	}

	@Test
	public void testReadMember() throws Exception {
		Member m = dao.selectMember(3);
		assertThat(m.getAge(), is(30));
	}

	@Test
	public void testReadWithTeam() throws Exception {
		Member m = dao.selectMemberWithAge(3, 30);
		assertThat(m != null, is(true));
	}
}
