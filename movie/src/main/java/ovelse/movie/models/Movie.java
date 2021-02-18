package ovelse.movie.models;

public class Movie {
    private int year;
    private int length;
    private String title;
    private String genre;
    private int popularity;
    private String award;

    public Movie(int year, int length, String title, String genre, int popularity, String award){
        this.year = year;
        this.length = length;
        this.title = title;
        this.genre = genre;
        this.popularity = popularity;
        this.award = award;

    }

    public String getTitle(){
        return this.title;
    }

    public int getPopularity(){
        return this.popularity;
    }

    public String getAward(){return this.award;}

}