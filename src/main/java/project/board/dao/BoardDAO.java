package project.board.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import project.board.vo.BoardVO;
import project.board.vo.SearchVO;

@Repository("boardDAO")
public class BoardDAO extends EgovAbstractMapper{
	
	public List<BoardVO> list(SearchVO searchVO) throws Exception{
		return list("board.list", searchVO);
	}
	
	public int ListTotCnt(SearchVO searchVO) {
		return (int)selectByPk("board.ListTotCnt", searchVO);
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

	public int delete(BoardVO boardVO) {
		return delete("board.delete", boardVO);
	}

	

}
