package global.sesoc.guestbook.dao;

import java.util.ArrayList;

import global.sesoc.guestbook.vo.GuestBook;

public interface GuestBookMapper {

	int write(GuestBook guestbook);
	
	GuestBook readOne(int num);
	
	ArrayList<GuestBook> readAll();
	
	int delete(int num);
	
	int update(GuestBook guestbook);
}
