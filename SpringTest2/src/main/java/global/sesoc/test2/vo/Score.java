package global.sesoc.test2.vo;

public class Score {
	private Integer kor;
	private Integer eng;
	private Integer mat;
	
	public Score() {
		
	}
	
	public Score(Integer kor, Integer eng, Integer mat) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public Integer getKor() {
		return kor;
	}
	public void setKor(Integer kor) {
		this.kor = kor;
	}
	public Integer getEng() {
		return eng;
	}
	public void setEng(Integer eng) {
		this.eng = eng;
	}
	public Integer getMat() {
		return mat;
	}
	public void setMat(Integer mat) {
		this.mat = mat;
	}
	
	@Override
	public String toString() {
		return "Score [kor=" + kor + ", eng=" + eng + ", mat=" + mat + "]";
	}
	
	public int getSum() {
		return kor + eng + mat;
	}
	
	public double getAvg() {
		return (kor + eng + mat) / 3.0;
	}
}
