package edu.bit.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j												// 매우 주의 : boardService 객체, boardMapper 객체를 생성해 사용하는 컨트롤러와 BoardServiceImpl 클래스에는
@AllArgsConstructor									// 반드시 객체 생성을 해주는 어노테이션이 있어야 함!!!! 없으면 NoSuchBeanDefinitionException 발생!!!!
@Controller
public class BoardController {
	private BoardService boardService;				// 접근 제한자에 신경 쓰자
	
	@RequestMapping("/list")								// throws Exception 잊지 말자
	public void list(Model model) throws Exception {		// DB에 처음 접근해서 데이터를 가져오는 것이므로 = 가져갈 것이 처음에는 없으므로 BoardVO는 쓰지 않는다.(담아서 가져가는 것이 아니라면 쓰지 않는다.)
		log.info("list");									// 로그 쓰도록 하자
		model.addAttribute("list", boardService.getList()); 		// ArrayList에 데이터를 담아올 것이므로, 메소드에 담는 것이 가능
	}																// service 인터페이스 만드는 것 잊지 말자
	
	@RequestMapping("/content_view")
	public void content_view(BoardVO boardVO, Model model) throws Exception  {
		boardService.addHit(boardVO);
		model.addAttribute("content_view", boardService.contentView(boardVO));
	}
	
	@RequestMapping("/write_view")
	public void write_view() throws Exception  {
		
	}
	
	@RequestMapping("/write")
	public String write(BoardVO boardVO) throws Exception {		// 주의 : write 작업 끝나면 list로 리턴!!!
		boardService.addWrite(boardVO);
		return "redirect:list";
	}
	
	@RequestMapping("/modify")
	public String modify(BoardVO boardVO) throws Exception  {		// 주의 : write 작업 끝나면 list로 리턴!!!
		boardService.addModify(boardVO);
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(BoardVO boardVO) throws Exception  {		// 주의 : write 작업 끝나면 list로 리턴!!!
		boardService.addDelete(boardVO);
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public void reply_view(BoardVO boardVO, Model model) throws Exception  {		
		model.addAttribute("reply_view", boardService.replyView(boardVO));
	}
	
	@RequestMapping("/reply")
	public String reply(BoardVO boardVO) throws Exception  {		
		boardService.replyShape(boardVO);
		boardService.reply(boardVO);
		return "redirect:list";
	}
}
