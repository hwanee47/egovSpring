package project.board.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import project.board.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAO extends EgovAbstractMapper{
	
	public List<BoardVO> list(BoardVO boardVO) throws Exception{
		return list("board.list", boardVO);
	}

}
