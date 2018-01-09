package global.sesoc.web8.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
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
	public ArrayList<Board> readAll(int page) {
		ArrayList<Board> result = null;
		
		// mybatis가 굳이 계산하지 않아도 글을 차례로 가져올 수 있도록 도와준다
		int count = 10; // 몇 개 가져올 것인가
		int start = (page - 1) * count; // 어디서부터 시작할 것인가
		
		try {
			
			// 자동으로 글을 순서대로 가져오기 위해 필요한 객체
			RowBounds rb = new RowBounds(start, count);
			
			BoardMapper mapper = sqlsession.getMapper(BoardMapper.class);
			result = mapper.readAll(rb);
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
	
	/**
	 * 게시판 제목 검색
	 * @param limit 페이지 당 보여줄 게시글 수
	 * @param page 현재 페이지
	 * @param select 검색 조건
	 * @param text 검색어
	 * @return
	 */
	public ArrayList<Board> search(int limit, int page, String select, String text) {
		ArrayList<Board> result = null;
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("select", select);
		map.put("text", text);
		
		// RowBounds(int offset, int limit)
		RowBounds rb = new RowBounds((page - 1) * limit, limit);
		
		try {
			BoardMapper mapper = sqlsession.getMapper(BoardMapper.class);
			result = mapper.selectList(rb, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 게시물의 총 개수를 반환. 검색 결과의 총 개수를 반환
	 * @param text
	 * @return
	 */
	public int selectTotalCount(String text) {
		int result = 0;
		
		try {
			BoardMapper mapper = sqlsession.getMapper(BoardMapper.class);
			result = mapper.selectTotalCount(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}

























