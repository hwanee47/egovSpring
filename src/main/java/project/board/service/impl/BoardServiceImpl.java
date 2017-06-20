package project.board.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import project.board.dao.BoardDAO;
import project.board.service.BoardService;
import project.board.vo.BoardVO;
import project.board.vo.SearchVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Resource(name = "boardDAO")
	BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> list(SearchVO searchVO) throws Exception {
		return boardDAO.list(searchVO);
	}
	
	@Override
	public int ListTotCnt(SearchVO searchVO) throws Exception {
		return boardDAO.ListTotCnt(searchVO);
	}

	@Override
	public int insert(BoardVO boardVO) throws Exception {
		return boardDAO.insert(boardVO);
	}

	@Override
	public BoardVO updateView(BoardVO boardVO) throws Exception {
		return boardDAO.updateView(boardVO);
	}

	@Override
	public int update(BoardVO boardVO) throws Exception {
		return boardDAO.update(boardVO);
	}

	@Override
	public int delete(BoardVO boardVO) throws Exception {
		return boardDAO.delete(boardVO);
	}

	

}
