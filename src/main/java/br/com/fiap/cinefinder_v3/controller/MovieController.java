package br.com.fiap.cinefinder_v3.controller;

import br.com.fiap.cinefinder_v3.dto.MovieResponse;
import br.com.fiap.cinefinder_v3.dto.ReviewResponse;
import br.com.fiap.cinefinder_v3.service.MovieService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@Log4j2
@AllArgsConstructor
public class MovieController {

    private MovieService service;

    @GetMapping
    public Page<MovieResponse> getMovies(@PageableDefault(size = 20, sort = "releaseDate", direction = Sort.Direction.DESC) Pageable pageable) {
        log.info("Getting movies");
        return service.getAll(pageable);
    }

    @GetMapping("/{id}")
    public MovieResponse getMovie(@PathVariable Long id) {
        log.info("Getting movie: {}", id);
        return service.getById(id);
    }

    @GetMapping("/{id}/reviews")
    public List<ReviewResponse> getReviews(@PathVariable Long id) {
        log.info("Getting reviews for movie: {}", id);
        return service.getMovieReviews(id);
    }


}
