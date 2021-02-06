package org.zerock.dao;

import org.zerock.domain.MemberVO;

/**
 *
 *
 * @author USER
 * @history
 *          2020. 12. 30. initial creation
 */
public interface MemberDAO {
	public String getTime();

	public void insertMember(MemberVO vo);

	public MemberVO readMember(String userid) throws Exception;

	public MemberVO readWithPW(String userid, String userpw) throws Exception;
}
