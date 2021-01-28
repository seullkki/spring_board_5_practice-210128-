package edu.bit.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j												// �ſ� ���� : boardService ��ü, boardMapper ��ü�� ������ ����ϴ� ��Ʈ�ѷ��� BoardServiceImpl Ŭ��������
@AllArgsConstructor									// �ݵ�� ��ü ������ ���ִ� ������̼��� �־�� ��!!!! ������ NoSuchBeanDefinitionException �߻�!!!!
@Controller
public class BoardController {
	private BoardService boardService;				// ���� �����ڿ� �Ű� ����
	
	@RequestMapping("/list")								// throws Exception ���� ����
	public void list(Model model) throws Exception {		// DB�� ó�� �����ؼ� �����͸� �������� ���̹Ƿ� = ������ ���� ó������ �����Ƿ� BoardVO�� ���� �ʴ´�.(��Ƽ� �������� ���� �ƴ϶�� ���� �ʴ´�.)
		log.info("list");									// �α� ������ ����
		model.addAttribute("list", boardService.getList()); 		// ArrayList�� �����͸� ��ƿ� ���̹Ƿ�, �޼ҵ忡 ��� ���� ����
	}																// service �������̽� ����� �� ���� ����
	
	@RequestMapping("/content_view")
	public void content_view(BoardVO boardVO, Model model) throws Exception  {
		boardService.addHit(boardVO);
		model.addAttribute("content_view", boardService.contentView(boardVO));
	}
	
	@RequestMapping("/write_view")
	public void write_view() throws Exception  {
		
	}
	
	@RequestMapping("/write")
	public String write(BoardVO boardVO) throws Exception {		// ���� : write �۾� ������ list�� ����!!!
		boardService.addWrite(boardVO);
		return "redirect:list";
	}
	
	@RequestMapping("/modify")
	public String modify(BoardVO boardVO) throws Exception  {		// ���� : write �۾� ������ list�� ����!!!
		boardService.addModify(boardVO);
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(BoardVO boardVO) throws Exception  {		// ���� : write �۾� ������ list�� ����!!!
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
