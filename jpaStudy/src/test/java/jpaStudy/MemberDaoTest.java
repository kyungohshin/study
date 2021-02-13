package jpaStudy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import dto.Member;
import dto.Team;
import repository.MemberRepository;
import repository.TeamRepository;

/**
 *
 *
 * @author USER
 * @history
 *          2020. 10. 11. initial creation
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/applicationContext.xml" })
public class MemberDaoTest {

	@Autowired
	private MemberRepository memberRepository; // spring data jpa사용시, entityManger에 직접 접근할필요가 없음.
	                                           // 내부적으로 알아서 사용

	@Autowired
	private TeamRepository teamRepository;

	@Test
	public void testInsertMember() throws Exception {
		Team t = new Team();
		t.setId(3);
		t.setName("teamC");

		Member vo = new Member();
		vo.setId(8);
		vo.setAge(38);
		vo.setUsername("park");
		vo.setTeam(t);

		t.getMember().add(vo);
		memberRepository.saveAndFlush(vo);
	}

	@Test
	public void testReadMember() throws Exception {
		Member m = memberRepository.findOne(3);
		assertThat(m.getAge(), is(30));
	}

	@Test
	@Transactional(readOnly = true) // lazy로딩을 위해서 조회시점까지 세션유지
	public void testReadWithTeam() throws Exception {
//		String jpql = "select m from Member m where m.id = 3 and m.age = 30";
//		Member m = em.createQuery(jpql, Member.class).getSingleResult();

		Member m = memberRepository.findByIdAndAge(3, 30);
		assertThat(m != null, is(true));
		System.out.println("LAZY@@");
		assertThat(m.getTeam().getName(), is("TeamA"));

	}

	@Test
	@Transactional(readOnly = true) // lazy로딩을 위해서 조회시점까지 세션유지
	public void testJoin() throws Exception { // Member -> Team만 가능함. 단방향이므로
//		String jpql = "select m from Member m join m.team t where t.id = 1 order by m.id";
//		List<Member> m = em.createQuery(jpql, Member.class).getResultList();

		Team t = new Team();
		t.setId(1);
		List<Member> m = memberRepository.findByTeamOrderById(t); // 조인이 될수밖에없음. team으로 조회를 하니까
		assertThat(m.size(), is(2));
		assertThat(m.get(1).getAge(), is(28));
		assertThat(m.get(1).getTeam().getName(), is("TeamA"));
	}

	@Test
	@Transactional(readOnly = true) // lazy로딩을 위해서 조회시점까지 세션유지
	public void testJoin2() throws Exception { // Team -> Member도 가능함.
		String jpql = "select t from Team t join t.member m where t.id = 1 order by m.id";
//		List<Team> t = em.createQuery(jpql, Team.class).getResultList();
//		List<Team> m
		Team t = teamRepository.findOne(1);
		assertThat(t.getMember().size(), is(2));
		assertThat(t.getMember().get(1).getAge(), is(28));
	}

}
