package org.zerock.dao;

import java.util.List;

import org.zerock.domain.BoardVO;

/**
 *
 *
 * @author USER
 * @history
 *          2020. 12. 31. initial creation
 */
public interface BoardDAO {
	public void create(BoardVO vo) throws Exception;

	public BoardVO read(Integer bno) throws Exception;

	public void update(BoardVO vo) throws Exception;

	public void delete(Integer bno) throws Exception;

	public List<BoardVO> listAll() throws Exception;
}
