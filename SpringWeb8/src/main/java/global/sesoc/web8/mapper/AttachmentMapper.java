package global.sesoc.web8.mapper;

import java.util.ArrayList;

import global.sesoc.web8.vo.Attachment;

public interface AttachmentMapper {
	
	int insert(Attachment attachment);
	
	ArrayList<Attachment> selectAll(int boardnum);
	
	Attachment selectOne(int attachmentnum);
	
	int update(Attachment attachment);
	
	int delete(int attachmentnum);
}
