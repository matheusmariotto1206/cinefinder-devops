package br.com.fiap.cinefinder_v3.controller;

import br.com.fiap.cinefinder_v3.dto.CreateMovieListDTO;
import br.com.fiap.cinefinder_v3.dto.MovieListResponse;
import br.com.fiap.cinefinder_v3.dto.UpdateMovieListDTO;
import br.com.fiap.cinefinder_v3.service.MovieListService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/lists")
@AllArgsConstructor
@Log4j2
public class MovieListController {

    private final MovieListService service;

    @GetMapping
    public Page<MovieListResponse> getLists(Pageable pageable) {
        log.info("Getting all movie lists ");
        return service.getAllMovieLists(pageable);
    }

    @GetMapping("/{id}")
    public MovieListResponse getMovieList(@PathVariable Long id) {
        log.info("Getting movie list with id {}", id);
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieListResponse createMovieList(@RequestBody CreateMovieListDTO movieList) {
        log.info("Creating movie list {}", movieList);
        return service.create(movieList);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovieList(@PathVariable Long id) {
        log.info("Deleting movie list with id {}", id);
        service.delete(id);
    }

    @PatchMapping("/{id}")
    public MovieListResponse updateMovieList(@PathVariable Long id, @RequestBody UpdateMovieListDTO movieList) {
        log.info("Updating movie list with id {}", id);
        return service.update(id, movieList);
    }

    @PostMapping("/{id}/movies/{movieId}")
    public MovieListResponse addMovie(@PathVariable Long id, @PathVariable Long movieId) {
        log.info("Adding movie {} to list {}", movieId, id);
        return service.addMovieToList(id, movieId);
    }

    @DeleteMapping("/{id}/movies/{movieId}")
    public MovieListResponse removeMovie(@PathVariable Long id, @PathVariable Long movieId) {
        log.info("Remove movie {} to list {}", movieId, id);
        return service.removeMovieToList(id, movieId);
    }
}
