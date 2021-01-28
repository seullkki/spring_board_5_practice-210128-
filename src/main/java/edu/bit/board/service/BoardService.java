package edu.bit.board.service;

import java.util.List;

import edu.bit.board.vo.BoardVO;


public interface BoardService {				// 인터페이스 만드는 것 잊지 말자! 
											// Q. 인터페이스인데 추상 메소드를 미리 만들지 않고 어떻게 작동하는 걸까?

	public List<BoardVO> getList(); 			// 여기서 데이터타입을 List로 주도록 하자 + 제네릭은 데이터가 담기는 VO로 주자

	public BoardVO contentView(BoardVO boardVO);

	public void addWrite(BoardVO boardVO);

	public void addModify(BoardVO boardVO);

	public void addDelete(BoardVO boardVO);

	public BoardVO replyView(BoardVO boardVO);

	public void reply(BoardVO boardVO);

	public void replyShape(BoardVO boardVO);

	public void addHit(BoardVO boardVO);
		


}
