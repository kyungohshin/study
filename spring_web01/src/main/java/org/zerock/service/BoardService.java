package org.zerock.service;

//...187p.
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.dao.BoardDAO;
import org.zerock.domain.BoardVO;

//...187, 376, 470p.@Service가 스프링의 빈으로 인식하게 함. root-context.xml::Beans Graph 확인할 것.
@Service
public class BoardService {

	@Inject
	private BoardDAO dao;

	public void create(BoardVO board) throws Exception {
		dao.create(board);
	}

	public BoardVO read(Integer bno) throws Exception {
		return dao.read(bno);
	}

	public void update(BoardVO board) throws Exception {
		dao.update(board);
	}

	public void delete(Integer bno) throws Exception {
		dao.delete(bno);
	}

	public List<BoardVO> listAll() throws Exception {
		return dao.listAll();
	}

}
