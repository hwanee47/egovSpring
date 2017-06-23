package project.board.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import project.board.service.BoardService;
import project.board.vo.BoardVO;
import project.board.vo.SearchVO;

/**

* 1. 패키지명 : project.board.controller

* 2. 타입명 : BoardController.java

* 3. 작성일 : 2017. 6. 22. 오후 12:22:33

* 4. 작성자 : kim

* 5. 설명 : 게시판 관련 소스


*/
/**

* 1. 패키지명 : project.board.controller

* 2. 타입명 : BoardController.java

* 3. 작성일 : 2017. 6. 22. 오후 12:23:13

* 4. 작성자 : kim

* 5. 설명 :


*/
@Controller
@RequestMapping(value= "/board")
public class BoardController {
	
	//게시판 1page에서 보여줄 개수
	public static final int pageUnit = 10;
	//게시판 하단에 보여줄 page Size
	public static final int pageSize = 10;

	@Resource(name = "boardService")
	private BoardService boardService;
	
	
	/**
	
	* 1. 메소드명 : getBoardList
	
	* 2. 작성일 : 2017. 6. 22. 오후 12:23:18
	
	* 3. 작성자 : kim
	
	* 4. 설명 : 게시판 리스트 
	
	* @param searchVO 검색조건
	* @param model
	* @return
	* @throws Exception
	
	*/
	@RequestMapping(value = "/list.do")
	public String getBoardList(@ModelAttribute("searchVO") SearchVO searchVO, ModelMap model) throws Exception{
		
		searchVO.setPageUnit(pageUnit);
		searchVO.setPageSize(pageSize);

		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List<?> list =  boardService.list(searchVO);
		model.addAttribute("list", list);
		
		int totCnt = boardService.ListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		return "board/boardList";
	}
	
	/**
	
	* 1. 메소드명 : getBoardinfo
	
	* 2. 작성일 : 2017. 6. 22. 오후 1:25:30
	
	* 3. 작성자 : kim
	
	* 4. 설명 : 게시판 작성화면
	
	* @param boardVO 게시판 상세정보 매핑
	* @param model
	* @return
	* @throws Exception
	
	*/
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String getBoardinfo(@ModelAttribute("boardVO") BoardVO boardVO, ModelMap model) throws Exception{
		
		return "board/boardRegister";
	}
	
	/**
	
	* 1. 메소드명 : insertBoardData
	
	* 2. 작성일 : 2017. 6. 22. 오후 1:26:16
	
	* 3. 작성자 : kim
	
	* 4. 설명 : 게시판 글작성
	
	* @param boardVO 게시판 상세정보 매핑
	* @param model
	* @return
	* @throws Exception
	
	*/
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public String insertBoardData(@ModelAttribute("boardVO") BoardVO boardVO, ModelMap model) throws Exception{
		BoardVO BoardVO = new BoardVO();
		int val = boardService.insert(boardVO);
		return "redirect:/board/list.do";
	}
	
	/**
	
	* 1. 메소드명 : updateBoardinfo
	
	* 2. 작성일 : 2017. 6. 22. 오후 1:27:06
	
	* 3. 작성자 : kim
	
	* 4. 설명 : 게시판 수정화면
	
	* @param no 게시판번호
	* @param boardVO 게시판 상세정보 매핑
	* @param model
	* @return
	* @throws Exception
	
	*/
	@RequestMapping(value="/update.do", method = RequestMethod.GET)
	public String updateBoardinfo(@RequestParam("no") String no,@ModelAttribute("boardVO") BoardVO boardVO, ModelMap model)throws Exception{
		BoardVO  select = new BoardVO();
		select.setNo(no);
		BoardVO detail = boardService.updateView(select);
		model.addAttribute("boardVO",detail);
		return "board/boardRegister";
	}
	
	/**
	
	* 1. 메소드명 : updateBoardData
	
	* 2. 작성일 : 2017. 6. 22. 오후 1:27:22
	
	* 3. 작성자 : kim
	
	* 4. 설명 : 게시판 수정정보 저장
	
	* @param boardVO 게시판 상세정보 매핑
	* @param model
	* @return
	* @throws Exception
	
	*/
	@RequestMapping(value="/update.do", method = RequestMethod.POST)
	public String updateBoardData(@ModelAttribute("boardVO") BoardVO boardVO, ModelMap model)throws Exception{
		int val = boardService.update(boardVO);
		return "redirect:/board/list.do";
	}
	
	/**
	
	* 1. 메소드명 : deleteBoardData
	
	* 2. 작성일 : 2017. 6. 22. 오후 1:28:37
	
	* 3. 작성자 : kim
	
	* 4. 설명 : 게시판 글 작성
	
	* @param boardVO 게시판 상세정보 매핑
	* @param model
	* @return
	* @throws Exception
	
	*/
	@RequestMapping(value="/delete.do", method = RequestMethod.POST)
	public String deleteBoardData(@ModelAttribute("boardVO") BoardVO boardVO, ModelMap model)throws Exception{
		int val = boardService.delete(boardVO);
		return "redirect:/board/list.do";
	}

	
}
