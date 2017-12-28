package global.sesoc.test1.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import global.sesoc.test1.vo.MovieVO;

public class MovieDAO {
	SqlSessionFactory sessionFactory = MybatisConfig.getSqlSessionFactory();
	
	/**
	 * 영화 정보 저장
	 * @param movie
	 * @return
	 */
	public boolean insertMovie(MovieVO movie) {
		SqlSession session = null;
		boolean result = false;
		
		try {
			session = sessionFactory.openSession();
			MovieMapper mapper = session.getMapper(MovieMapper.class);
			
			if (mapper.insertMovie(movie) == 1) {
				result = true;
			}
			
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return result;
	}
	
	public ArrayList<MovieVO> readMovies() {
		SqlSession session = null;
		ArrayList<MovieVO> result = null;
		
		try {
			session = sessionFactory.openSession();
			MovieMapper mapper = session.getMapper(MovieMapper.class);
			
			result = mapper.selectMovies();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return result;
	}
}





























