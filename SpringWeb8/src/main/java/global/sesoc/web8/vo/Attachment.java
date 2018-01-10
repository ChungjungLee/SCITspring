package global.sesoc.web8.vo;

public class Attachment {
	private int attachmentnum;
	private int boardnum;
	private String originalfile;
	private String savedfile;
	
	public Attachment() {}
	
	public Attachment(int attachmentnum, int boardnum, String originalfile, String savedfile) {
		this.attachmentnum = attachmentnum;
		this.boardnum = boardnum;
		this.originalfile = originalfile;
		this.savedfile = savedfile;
	}
	
	public int getAttachmentnum() {
		return attachmentnum;
	}
	public void setAttachmentnum(int attachmentnum) {
		this.attachmentnum = attachmentnum;
	}
	public int getBoardnum() {
		return boardnum;
	}
	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}
	public String getOriginalfile() {
		return originalfile;
	}
	public void setOriginalfile(String originalfile) {
		this.originalfile = originalfile;
	}
	public String getSavedfile() {
		return savedfile;
	}
	public void setSavedfile(String savedfile) {
		this.savedfile = savedfile;
	}

	@Override
	public String toString() {
		return "Attachment [attachmentnum=" + attachmentnum + ", boardnum=" + boardnum + ", originalfile="
				+ originalfile + ", savedfile=" + savedfile + "]";
	}
	
}
