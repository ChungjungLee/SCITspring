package global.sesoc.web8.mapper;

import java.util.ArrayList;

import global.sesoc.web8.vo.Reply;

public interface ReplyMapper {
	
	int write(Reply reply);
	
	ArrayList<Reply> readAll(int boardnum);
	
}
