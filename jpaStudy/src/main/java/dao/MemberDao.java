package dao;

import java.util.List;

import dto.Member;

/**
 *
 *
 * @author USER
 * @history
 *          2020. 12. 30. initial creation
 */
public interface MemberDao {
	public void insertMember(Member vo) throws Exception;

	public Member selectMember(int id) throws Exception;

	public List<Member> selectMemberList() throws Exception;

	public Member selectMemberWithAge(int id, int age) throws Exception;

	public void deleteMember(int id) throws Exception;

	public List<Member> selectMemberJoinTeam(int team_id) throws Exception;
}
