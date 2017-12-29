package global.sesoc.guestbook.vo;

public class GuestBook {
	private int num;
	private String author;
	private String content;
	private String password;
	private String indate;
	
	public GuestBook() {}
	
	public GuestBook(int num, String author, String content, String password, String indate) {
		this.num = num;
		this.author = author;
		this.content = content;
		this.password = password;
		this.indate = indate;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}

	@Override
	public String toString() {
		return "GuestBook [num=" + num + ", author=" + author + ", content=" + content + ", password=" + password
				+ ", indate=" + indate + "]";
	}
	
}