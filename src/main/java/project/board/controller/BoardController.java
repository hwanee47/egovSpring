package project.board.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import project.board.service.BoardService;
import project.board.vo.BoardVO;
import project.board.vo.SearchVO;

@Controller
@RequestMapping(value= "/board")
public class BoardController {
	
	public static final int pageUnit = 10;
	public static final int pageSize = 10;

	@Resource(name = "boardService")
	private BoardService boardService;
	
	
	@RequestMapping(value = "/list.do")
	public String list(@ModelAttribute("searchVO") SearchVO searchVO, ModelMap model) throws Exception{
		
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
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String insertView(@ModelAttribute("boardVO") BoardVO boardVO, ModelMap model) throws Exception{
		
		return "board/boardRegister";
	}
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public String insert(@ModelAttribute("boardVO") BoardVO boardVO, ModelMap model) throws Exception{
		BoardVO BoardVO = new BoardVO();
		int val = boardService.insert(boardVO);
		return "redirect:/board/list.do";
	}
	
	@RequestMapping(value="/update.do", method = RequestMethod.GET)
	public String updateView(@RequestParam("no") String no,@ModelAttribute("boardVO") BoardVO boardVO, ModelMap model)throws Exception{
		BoardVO  select = new BoardVO();
		select.setNo(no);
		BoardVO detail = boardService.updateView(select);
		model.addAttribute("boardVO",detail);
		return "board/boardRegister";
	}
	
	@RequestMapping(value="/update.do", method = RequestMethod.POST)
	public String update(@ModelAttribute("boardVO") BoardVO boardVO, ModelMap model)throws Exception{
		int val = boardService.update(boardVO);
		return "redirect:/board/list.do";
	}
	
	@RequestMapping(value="/delete.do", method = RequestMethod.POST)
	public String delete(@ModelAttribute("boardVO") BoardVO boardVO, ModelMap model)throws Exception{
		int val = boardService.delete(boardVO);
		return "redirect:/board/list.do";
	}

	
}
