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

import project.board.service.BoardService;
import project.board.vo.BoardVO;
import project.board.vo.SearchVO;

@Controller
@RequestMapping(value= "/board")
public class BoardController {
	
	@Resource(name = "boardService")
	private BoardService boardService;
	
	@RequestMapping(value = "/list.do")
	public String list(@ModelAttribute("boardVO") BoardVO boardVO, ModelMap model) throws Exception{
		
		List<BoardVO> list =  boardService.list(boardVO);
		model.addAttribute("list", list);
		
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
		return "redirect:/board/boardList";
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
		return "redirect:/board/boardList";
	}

	
}
