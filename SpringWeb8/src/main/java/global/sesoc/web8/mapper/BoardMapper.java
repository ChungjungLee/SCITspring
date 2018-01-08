package global.sesoc.web8.mapper;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;

import global.sesoc.web8.vo.Board;

public interface BoardMapper {
	
	int totalNum();
	
	ArrayList<Board> readAll(RowBounds rb);
	
	Board readOne(int boardnum);
	
	int write(Board board);
	
	int updateHits(int boardnum);
	
	int update(Board board);
	
	int delete(int boardnum);
	
}
