package global.sesoc.web2.vo;

public class ConverterLen {
	private String from;
	private String to;
	private double convert;
	
	public ConverterLen() {}
	
	public ConverterLen(String from, String to, double convert) {
		super();
		this.from = from;
		this.to = to;
		this.convert = convert;
	}

	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public double getConvert() {
		return convert;
	}
	public void setConvert(double convert) {
		this.convert = convert;
	}
	
	public double getConvertRev() {
		return 1 / convert;
	}
	
	public boolean isCorrect(String from, String to) {
		if (from.equals(this.from) && to.equals(this.to)) {
			return true;
		} else if (from.equals(this.to) && to.equals(this.from)) {
			return true;
		} else {
			return false;
		}
	}
	
}
