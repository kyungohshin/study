package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSession sqlSession;

	private static final String namespace = "dao.MemberDao";

	@Override
	public void insertMember(Member vo) throws Exception {
		sqlSession.insert(namespace + ".insertMember", vo);
	}

	@Override
	public Member selectMember(int id) throws Exception {
		return sqlSession.selectOne(namespace + ".selectMember", id);
	}

	@Override
	public List<Member> selectMemberList() throws Exception {
		return sqlSession.selectList(namespace + ".selectMemberList");
	}

	@Override
	public Member selectMemberWithAge(int id, int age) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("age", age);
		return sqlSession.selectOne(namespace + ".selectMemberWithAge", map);
	}

	@Override
	public void deleteMember(int id) throws Exception {
		sqlSession.selectOne(namespace + ".deleteMember", id);
	}

}
