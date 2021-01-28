package edu.bit.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j														// ������̼� ��������!!!!!
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {		// �������̽��� ������ �޼ҵ��� ���� �κ� = mapper�� ���������� �������ִ� �κ�

	private BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> getList() {
		
		return boardMapper.list();					// select�ϴ� ��쿡�� ������ �־ mapper���� DB�� ������ �����͸� ������ �ٽ� ���ƿͼ� getList �޼ҵ忡 ��ұ� ������ ��Ʈ�ѷ����� ����� ������ ����.
	}												// select �̿ܿ��� ������ ����.

	@Override
	public BoardVO contentView(BoardVO boardVO) {
		return boardMapper.conView(boardVO.getiId());			// ���� : list.jsp���� id���� �ϳ� ������ ����. �̰��� �̿��� DB���� ���ϴ� �����͸� ���� ����. ���� ����, ���۸� ��ġ�� �޼ҵ鸦 ���� �� �̰��� ���ڷ� �־�� ��.
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
	public void addDelete(BoardVO boardVO) {				// jsp���� url�� get������� �����͸� �޴� ��� (delete, contentview, replyView)���� ������ �޴� �� �ƴϹǷ� ��ü�� get�޼ҵ�� �����͸� �ҷ��;� ��
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
