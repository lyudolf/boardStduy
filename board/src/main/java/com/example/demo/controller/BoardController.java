package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/write")
	public String boardWriteForm() {
		return "boardwrite";
	}
	
	@PostMapping("/board/writedo")
	public String boardWriteDo(Board board) {
		boardService.write(board);
		return "";
	}
	
	@GetMapping("/board/list")
	public String boardList(Model model) {
		
		model.addAttribute("list",boardService.boardList());
		
		return "boardlist";
	}
	
	@GetMapping("/board/view")  
	public String boardView(Model model, Integer id) {
		model.addAttribute("board", boardService.boardView(id));
		
		return "boardview";
	}

}
