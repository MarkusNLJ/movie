package ovelse.movie.MovieController;

import ovelse.movie.models.Movie;
import ovelse.movie.services.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;


@Controller
public class ControllerMovie {

    MovieService movieService = new MovieService("src/main/resources/static/film-new.csv");

    @ResponseBody
    @GetMapping("/")
    public String helloWorld(){
        return "Du ser godt ud idag :D";
    }

    @ResponseBody
    @GetMapping("/getFirst")
    public String getFirst() {
        Movie firstMovieOfList = movieService.getFirstMovieOfList();
        return firstMovieOfList.getTitle();
    }

    @ResponseBody
    @GetMapping("/getRandom")
    public String getRandom(){
        Movie randomMovie = movieService.getRandom();
        return randomMovie.getTitle();
    }

    @ResponseBody
    @GetMapping("/getTen")
    public ArrayList<String> getTen(){
        ArrayList<String> printMovies = new ArrayList<>();
       ArrayList<Movie> movies = movieService.getTen();
        for (int i = 0; i < movies.size(); i++) {
            printMovies.add(movies.get(i).getTitle());
        }
        return printMovies;
    }

    @ResponseBody
    @GetMapping("/award")
    public ArrayList<String> getWinners(){
        ArrayList<String> printMovies = new ArrayList<>();
        ArrayList<Movie> movies = movieService.awardWinners();
        for (int i = 0; i < movies.size(); i++) {
            printMovies.add(movies.get(i).getTitle());
        }
        return printMovies;
    }

}
