package project.board.service;

import java.util.List;

import project.board.vo.BoardVO;

public interface BoardService {

	public List<BoardVO> list(BoardVO boardVO) throws Exception;

}
