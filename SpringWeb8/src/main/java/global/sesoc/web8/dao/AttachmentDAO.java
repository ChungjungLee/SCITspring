package global.sesoc.web8.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.web8.mapper.AttachmentMapper;
import global.sesoc.web8.vo.Attachment;

@Repository
public class AttachmentDAO {
	@Autowired
	SqlSession sqlsession;
	
	/**
	 * 첨부파일을 데이터베이스에 저장
	 * @return
	 */
	public int write(Attachment attachment) {
		int result = 0;
		
		try {
			AttachmentMapper mapper = sqlsession.getMapper(AttachmentMapper.class);
			result = mapper.insert(attachment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 해당 글에 딸려 있는 모든 첨부파일 가져오기
	 * @param boardnum
	 * @return
	 */
	public ArrayList<Attachment> readAll(int boardnum) {
		ArrayList<Attachment> result = null;
		
		try {
			AttachmentMapper mapper = sqlsession.getMapper(AttachmentMapper.class);
			result = mapper.selectAll(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 해당 글에 달려 있는 첨부파일 중 하나 가져오기
	 * @param attachmentnum
	 * @return
	 */
	public Attachment readOne(int attachmentnum) {
		Attachment result = null;
		
		try {
			AttachmentMapper mapper = sqlsession.getMapper(AttachmentMapper.class);
			result = mapper.selectOne(attachmentnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 첨부파일 수정하기
	 * @param attachment
	 * @return
	 */
	public int update(Attachment attachment) {
		int result = 0;
		
		try {
			AttachmentMapper mapper = sqlsession.getMapper(AttachmentMapper.class);
			result = mapper.update(attachment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 해당 글에 달려 있는 첨부파일을 삭제하기
	 * @param attachmentnum
	 * @return
	 */
	public int delete(int attachmentnum) {
		int result = 0;
		
		try {
			AttachmentMapper mapper = sqlsession.getMapper(AttachmentMapper.class);
			result = mapper.delete(attachmentnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}



























