package project.board.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import project.board.dao.BoardDAO;
import project.board.service.BoardService;
import project.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Resource(name = "boardDAO")
	BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> list(BoardVO boardVO) throws Exception {
		return boardDAO.list(boardVO);
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

}
