package ovelse.movie.services;
import ovelse.movie.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MovieService {
    private File fileOfMovies;
    private Scanner scanner;
    private ArrayList<Movie> listOfMovies;
    private ArrayList<Movie> sortedListOfMovies;

    public MovieService(String path){
        this.fileOfMovies = new File(path);
        try{
            this.scanner = new Scanner(this.fileOfMovies);
        } catch (FileNotFoundException fejl){
            System.out.println("File not found");
        }
    }

        public Movie getFirstMovieOfList() {
                //Skip 2 lines
                scanner.nextLine();
                scanner.nextLine();
                //Split
                String[] firstMovieAsArray = scanner.nextLine().split(";");

                //Created a model from data
                Movie firstMovie = new Movie(
                        Integer.parseInt(firstMovieAsArray[0]), Integer.parseInt(firstMovieAsArray[1]),
                        firstMovieAsArray[2], firstMovieAsArray[3], Integer.parseInt(firstMovieAsArray[4]), firstMovieAsArray[5]);
            return firstMovie;
        }

        public Movie getRandom(){
            Random random = new Random();
            // den går langsomt ned af listen :/
            int randomMovieint = random.nextInt(5)+2;
            for (int i = 0; i < randomMovieint; i++) {
                scanner.nextLine();
            }
            //Split
            String[] firstMovieAsArray = scanner.nextLine().split(";");

            //Created a model from data
            Movie randomMovie = new Movie(
                    Integer.parseInt(firstMovieAsArray[0]), Integer.parseInt(firstMovieAsArray[1]),
                    firstMovieAsArray[2], firstMovieAsArray[3], Integer.parseInt(firstMovieAsArray[4]), firstMovieAsArray[5]
            );
            return randomMovie;
        }


    public ArrayList<Movie> getTen(){
        ArrayList<Movie> randomMovieList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            randomMovieList.add(getRandom());
           // Collections.sort(randomMovieList, Collections.reverseOrder());
        }

        return randomMovieList;
    }

    public ArrayList<Movie> awardWinners(){
        ArrayList<Movie> winners = new ArrayList<>();
        ArrayList<Movie> movies = new ArrayList<>();
        scanner.nextLine();
        scanner.nextLine();
        while(scanner.hasNextLine()){
            String[] movieAsArray = scanner.nextLine().split(";");
            Movie addMovie = new Movie(
                    Integer.parseInt(movieAsArray[0]), Integer.parseInt(movieAsArray[1]),
                    movieAsArray[2], movieAsArray[3], Integer.parseInt(movieAsArray[4]),  movieAsArray[5]
            );

            movies.add(addMovie);
        }
        for (int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getAward().equals("Yes")){
                winners.add(movies.get(i));
            }
        }
        return winners;
    }

}
