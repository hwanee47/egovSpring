package project.board.service;

import java.util.List;

import project.board.vo.BoardVO;
import project.board.vo.SearchVO;

public interface BoardService {

	public List<?> list(SearchVO searchVO) throws Exception;

	public int insert(BoardVO boardVO)  throws Exception;

	public BoardVO updateView(BoardVO boardVO) throws Exception;

	public int update(BoardVO boardVO) throws Exception;

	public int delete(BoardVO boardVO) throws Exception;

	public int ListTotCnt(SearchVO searchVO) throws Exception;

}
