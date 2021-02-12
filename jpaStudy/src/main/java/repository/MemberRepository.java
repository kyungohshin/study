package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dto.Member;

/**
 *
 *
 * @author USER
 * @history
 *          2020. 12. 30. initial creation
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
	public Member findByIdAndAge(int id, int age) throws Exception;

//	public List<Member> selectMemberJoinTeam(int team_id) throws Exception;
}
