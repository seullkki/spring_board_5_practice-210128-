package edu.bit.board.mapper;

import java.util.List;

import edu.bit.board.vo.BoardVO;

public interface BoardMapper {

	public List<BoardVO> list();

	public BoardVO conView(int iId);

	public void write(BoardVO boardVO);

	public void modify(BoardVO boardVO);

	public void delete(int iId);

	public BoardVO replyView(int iId);

	public void reply(BoardVO boardVO);

	public void replyShape(BoardVO boardVO);

	public void hit(int iId);

}

