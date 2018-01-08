package global.sesoc.web8.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.web8.mapper.BoardMapper;
import global.sesoc.web8.vo.Board;

@Repository
public class BoardDAO {
	
	@Autowired
	SqlSession sqlsession;
	
	/**
	 * 글 쓰기
	 * @param board
	 * @return
	 */
	public int write(Board board) {
		int result = 0;
		
		try {
			BoardMapper mapper = sqlsession.getMapper(BoardMapper.class);
			result = mapper.write(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 모든 글 읽기
	 * @return
	 */
	public ArrayList<Board> readAll() {
		ArrayList<Board> result = null;
		
		try {
			BoardMapper mapper = sqlsession.getMapper(BoardMapper.class);
			result = mapper.readAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 글 하나 읽기
	 * @param boardnum
	 * @return
	 */
	public Board readOne(int boardnum) {
		Board result = null;
		
		try {
			BoardMapper mapper = sqlsession.getMapper(BoardMapper.class);
			result = mapper.readOne(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 조회수 증가
	 * @param boardnum
	 * @return
	 */
	public int updateHits(int boardnum) {
		int result = 0;
		
		try {
			BoardMapper mapper = sqlsession.getMapper(BoardMapper.class);
			result = mapper.updateHits(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 해당 글을 수정한다
	 * @param board
	 * @return
	 */
	public int update(Board board) {
		int result = 0;
		
		try {
			BoardMapper mapper = sqlsession.getMapper(BoardMapper.class);
			result = mapper.update(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 해당 게시글을 삭제한다
	 * @param boardnum
	 * @return
	 */
	public int delete(int boardnum) {
		int result = 0;
		
		try {
			BoardMapper mapper = sqlsession.getMapper(BoardMapper.class);
			result = mapper.delete(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}

























