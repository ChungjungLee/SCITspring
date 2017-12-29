package global.sesoc.guestbook.dao;

import java.util.ArrayList;

import global.sesoc.guestbook.vo.GuestBook;

public interface GuestBookMapper {

	int write(GuestBook guestbook);
	
	ArrayList<GuestBook> readAll();
	
	int delete(int num);
	
	int update();
}
