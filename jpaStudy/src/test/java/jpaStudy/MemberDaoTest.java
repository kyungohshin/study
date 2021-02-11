package jpaStudy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dto.Member;
import dto.Team;

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

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;

	@Before
	public void setup() {
		emf = Persistence.createEntityManagerFactory("shin"); // 전체 애플리케이션에서 1개만생성
		this.em = emf.createEntityManager(); // 실제로 쓸때마다 생성
		tx = em.getTransaction();
	}

	@After
	public void close() {
		em.close();
		emf.close();
	}

//	@Test
	public void testInsertMember() throws Exception {
		tx.begin();

		Member vo = new Member();
		vo.setId(7);
		vo.setAge(24);
		vo.setUsername("gwon");
		em.persist(vo);

		Team t = new Team();
		t.setId(3);
		t.setName("teamC");
		t.getMember().add(vo);
		em.persist(t);

		tx.commit();
	}

	@Test
	public void testReadMember() throws Exception {
		tx.begin();
		Member m = em.find(Member.class, 3);
		assertThat(m.getAge(), is(30));
		tx.commit();
	}

	@Test
	public void testReadWithTeam() throws Exception {
		tx.begin();
		String jpql = "select m from Member m where m.id = 3 and m.age = 30";
		Member m = em.createQuery(jpql, Member.class).getSingleResult();
		assertThat(m != null, is(true));
		tx.commit();
	}

	@Test
	public void testJoin() throws Exception { // Team -> Member만 가능함. 단방향이므로
		tx.begin();
		String jpql = "select t from Team t join t.member m where t.id = 1 order by t.id";
		List<Team> t = em.createQuery(jpql, Team.class).getResultList();
		assertThat(t.size(), is(2));
		assertThat(t.get(1).getMember().get(1).getAge(), is(28));
		tx.commit();
	}
}
