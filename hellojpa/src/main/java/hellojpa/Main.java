package hellojpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hellojpa.entity.Member;
import hellojpa.entity.Team;

public class Main {
	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			Team team = new Team();
			team.setName("TeamA");
			em.persist(team);

			Team team2 = new Team();
			team2.setName("TeamB");
			em.persist(team2);

			Member member = new Member();
			member.setName("member1");
			member.setAge(30);
			member.setTeam(team);
			em.persist(member);

			Member member2 = new Member();
			member2.setName("member2");
			member2.setAge(28);
			member2.setTeam(team);
			em.persist(member2);

			team.getMembers().add(member);
			team.getMembers().add(member2);

			em.flush();
			em.clear();

//			String jpql = "SELECT m FROM Member m join fetch m.team t";
			String jpql = "SELECT t FROM Team t join fetch t.members";
			List<Team> result = em.createQuery(jpql, Team.class).getResultList();
			System.out.println(result.get(0).getName());
			em.close();

//			Team findTeam = findMember.getTeam();
//			member2.setName("membertt");
//			System.out.println(findTeam.getName());

//			Member findMember = em.find(Member.class, member.getId());;
//			Team findTeam = findMember.getTeam(); // member��ü�� ã������ team��ü�� �� �ȿ� �����Ƿ� �ٷ� ��ȸ����
//			System.out.println("@@@@@@@@@@@@"+findTeam.getName());
//
//			List<Member> members = findTeam.getMembers();
//			for(Member member1 : members) {
//				System.out.println("@!!!!!"+member1);
//			}

			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
			tx.rollback();
		} finally {
			em.close();
		}

		emf.close();
	}
}
