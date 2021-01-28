package edu.bit.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j														// 어노테이션 잊지말자!!!!!
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {		// 인터페이스에 생성된 메소드의 구현 부분 = mapper와 본격적으로 연결해주는 부분

	private BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> getList() {
		
		return boardMapper.list();					// select하는 경우에는 리턴이 있어서 mapper에서 DB에 접근해 데이터를 가져와 다시 돌아와서 getList 메소드에 담았기 때문에 컨트롤러에서 사용이 가능한 것임.
	}												// select 이외에는 리턴이 없음.

	@Override
	public BoardVO contentView(BoardVO boardVO) {
		return boardMapper.conView(boardVO.getiId());			// 주의 : list.jsp에서 id값을 하나 가지고 왔음. 이것을 이용해 DB에서 원하는 데이터를 뽑을 것임. 따라서 서비스, 맵퍼를 거치는 메소들를 만들 때 이것을 인자로 주어야 함.
	}

	@Override
	public void addWrite(BoardVO boardVO) {
		boardMapper.write(boardVO);
	}

	@Override
	public void addModify(BoardVO boardVO) {
		boardMapper.modify(boardVO);
	}

	@Override
	public void addDelete(BoardVO boardVO) {				// jsp에서 url에 get방식으로 데이터를 받는 경우 (delete, contentview, replyView)에는 폼으로 받는 게 아니므로 객체의 get메소드로 데이터를 불러와야 함
		boardMapper.delete(boardVO.getiId());
	}

	@Override
	public BoardVO replyView(BoardVO boardVO) {
		return boardMapper.replyView(boardVO.getiId());
	}

	@Override
	public void reply(BoardVO boardVO) {
		boardMapper.reply(boardVO);
	}

	@Override
	public void replyShape(BoardVO boardVO) {
		boardMapper.replyShape(boardVO);
	}

	@Override
	public void addHit(BoardVO boardVO) {
		boardMapper.hit(boardVO.getiId());
	}												

}
