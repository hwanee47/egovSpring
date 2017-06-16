package project.board.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import project.board.service.BoardService;
import project.board.vo.BoardVO;

@Controller
@RequestMapping(value= "/board")
public class BoardController {

	@Resource(name = "boardService")
	private BoardService boardService;
	
	@RequestMapping("/list.do")
	public String list(@ModelAttribute("boardVO") BoardVO boardVO, ModelMap model) throws Exception{
		
		List<BoardVO> list =  boardService.list(boardVO);
		model.addAttribute("list", list);
		
		return "board/boardList";
	}

	
}
