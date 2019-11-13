package com.example.test.movie;

public class MovieDto {
    private String title;
    private String director;

    MovieDto(String title, String director) {
        this.title = title;
        this.director = director;
    }

    public MovieModel toMovieModel() {
        return new MovieModel(getTitle(), getDirector());
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

}
