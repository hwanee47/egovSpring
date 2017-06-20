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

	public int insert(BoardVO boardVO) throws Exception{
		return insert("board.insert", boardVO);
	}

	public BoardVO updateView(BoardVO boardVO) throws Exception{
		return (BoardVO)selectByPk("board.updateView", boardVO);
	}

	public int update(BoardVO boardVO) {
		return update("board.update", boardVO);
	}

}
