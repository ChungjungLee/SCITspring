package global.sesoc.test1.dao;

import java.util.ArrayList;

import global.sesoc.test1.vo.MovieVO;

public interface MovieMapper {

	public int insertMovie(MovieVO movie);
	
	public ArrayList<MovieVO> selectMovies();
}
