package edu.bit.board.service;

import java.util.List;

import edu.bit.board.vo.BoardVO;


public interface BoardService {				// �������̽� ����� �� ���� ����! 
											// Q. �������̽��ε� �߻� �޼ҵ带 �̸� ������ �ʰ� ��� �۵��ϴ� �ɱ�?

	public List<BoardVO> getList(); 			// ���⼭ ������Ÿ���� List�� �ֵ��� ���� + ���׸��� �����Ͱ� ���� VO�� ����

	public BoardVO contentView(BoardVO boardVO);

	public void addWrite(BoardVO boardVO);

	public void addModify(BoardVO boardVO);

	public void addDelete(BoardVO boardVO);

	public BoardVO replyView(BoardVO boardVO);

	public void reply(BoardVO boardVO);

	public void replyShape(BoardVO boardVO);

	public void addHit(BoardVO boardVO);
		


}
