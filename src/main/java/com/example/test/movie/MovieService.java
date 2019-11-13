package com.example.test.movie;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    MovieService(MovieRepository movieRepository) {

        this.movieRepository = movieRepository;
    }

    public List<MovieModel> fetchAllMovies() throws IOException {
        List<MovieModel> allEntities;
        try {
            allEntities = StreamSupport.stream(movieRepository.findAll().spliterator(), false)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Failed to fetch entities: " + e.getMessage());
            throw new IOException("Failed to connect to db.");
        }
        return allEntities;
    }

    public List<MovieModel> createMovie(MovieDto movieDto) throws IOException {
        List<MovieModel> allEntities;
        try {
            movieRepository.save(movieDto.toMovieModel());
            allEntities = StreamSupport.stream(movieRepository.findAll().spliterator(), false)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Failed to create new entity: " + e.getMessage());
            throw new IOException("Failed to connect to db.");
        }
        return allEntities;
    }

    public MovieModel fetchMovieById(@PathVariable Integer id) throws IOException {
        MovieModel entity;
        try {
            entity = movieRepository.findById(id).get();
        } catch(Exception e) {
            System.out.println("Failed to find entity: " + e.getMessage());
            throw new IOException("Failed to connect to db");
        }
        return entity;
    }
}
