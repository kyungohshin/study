package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dto.Member;
import dto.Team;

/**
 *
 *
 * @author USER
 * @history
 *          2020. 12. 30. initial creation
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
	public List<Member> findByTeamOrderById(Team team) throws Exception;

	public Member findByIdAndAge(int id, int age) throws Exception;

//	public List<Member> selectMemberJoinTeam(int team_id) throws Exception;
}
