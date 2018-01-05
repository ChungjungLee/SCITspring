package global.sesoc.web8.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.web8.mapper.ReplyMapper;
import global.sesoc.web8.vo.Reply;

@Repository
public class ReplyDAO {
	
	@Autowired
	SqlSession sqlsession;
	
	/**
	 * 리플 달기
	 * @param reply
	 * @return
	 */
	public int write(Reply reply) {
		int result = 0;
		
		try {
			ReplyMapper mapper = sqlsession.getMapper(ReplyMapper.class);
			result = mapper.write(reply);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 해당 글에 딸린 모든 리플 읽어오기
	 * @param boardnum
	 * @return
	 */
	public ArrayList<Reply> readAll(int boardnum) {
		ArrayList<Reply> result = null;
		
		try {
			ReplyMapper mapper = sqlsession.getMapper(ReplyMapper.class);
			result = mapper.readAll(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}























