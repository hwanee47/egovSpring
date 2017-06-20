package project.board.service;

import java.util.List;

import project.board.vo.BoardVO;

public interface BoardService {

	public List<BoardVO> list(BoardVO boardVO) throws Exception;

	public int insert(BoardVO boardVO)  throws Exception;

	public BoardVO updateView(BoardVO boardVO) throws Exception;

	public int update(BoardVO boardVO) throws Exception;

}
