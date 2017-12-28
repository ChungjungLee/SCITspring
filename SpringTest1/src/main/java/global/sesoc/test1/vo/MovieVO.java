package global.sesoc.test1.vo;

public class MovieVO {
	private String title;
	private String director;
	private double stars;
	
	public MovieVO () { }

	public MovieVO(String title, String director, double stars) {
		this.title = title;
		this.director = director;
		this.stars = stars;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public double getStars() {
		return stars;
	}

	public void setStars(double stars) {
		this.stars = stars;
	}

	@Override
	public String toString() {
		return "MovieVO [title=" + title + ", director=" + director + ", stars=" + stars + "]";
	}
	
	
}
