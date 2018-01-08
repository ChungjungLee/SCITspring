package global.sesoc.web8.mapper;

import java.util.ArrayList;

import global.sesoc.web8.vo.Board;

public interface BoardMapper {
	
	ArrayList<Board> readAll();
	
	Board readOne(int boardnum);
	
	int write(Board board);
	
	int updateHits(int boardnum);
	
	int update(Board board);
	
	int delete(int boardnum);
	
}
