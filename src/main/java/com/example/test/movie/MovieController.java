package com.example.test.movie;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private MovieService movieService;

    MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieModel> getAllMovies() throws IOException {
        return movieService.fetchAllMovies();
    }

    @PostMapping
    public List<MovieModel> createMovie(@RequestBody MovieDto movieDto) throws IOException {
        return movieService.createMovie(movieDto);
    }

    @GetMapping("/{id}")
    public MovieModel getSingleMovie(@PathVariable Integer id) throws IOException {
        return movieService.fetchMovieById(id);
    }

    /*@DeleteMapping
    public List<MovieModel> deleteMovie(@RequestBody Id id) throws IOException {
        return movieService.deleteMovie(id);
    }*/
}
