package global.sesoc.test1;

import java.util.ArrayList;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.test1.dao.MovieDAO;
import global.sesoc.test1.vo.MovieVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome movie home!");
		
		return "home";
	}
	
	@RequestMapping(value = "/inputpage", method = RequestMethod.GET)
	public String inputPage() {
		return "inputPage";
	}
	
	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String storeMovie(MovieVO movie, Model model) {
		
		// DB에 영화 정보 저장
		MovieDAO dao = new MovieDAO();
		
		if (dao.insertMovie(movie)) {
			logger.info("movie info stored in db.");
		}
		
		model.addAttribute("vo", movie);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String readMovies(Model model) {
		MovieDAO dao = new MovieDAO();
		
		ArrayList<MovieVO> movieList = dao.readMovies();
		
		model.addAttribute("movieList", movieList);
		
		return "readPage";
	}
}
