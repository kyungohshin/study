package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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

	public Member selectMemberWithAge(@Param("id") int id, @Param("age") int age) throws Exception;

	public void deleteMember(int id) throws Exception;
}
