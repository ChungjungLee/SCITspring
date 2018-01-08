package global.sesoc.web8.mapper;

import java.util.ArrayList;

import global.sesoc.web8.vo.Reply;

public interface ReplyMapper {
	
	int write(Reply reply);
	
	ArrayList<Reply> readAll(int boardnum);
	
	Reply readOne(int replynum);
	
	int update(Reply reply);
	
	int delete(int replynum);
	
	void decrease_seq();
}
