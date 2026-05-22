package br.com.fiap.cinefinder_v3.dto;

import br.com.fiap.cinefinder_v3.model.GENRE;
import br.com.fiap.cinefinder_v3.model.Movie;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public record MovieResponse(
        Long id,
        String title,
        String description,
        LocalDate releaseDate,
        BigDecimal averageRating,
        Set<String> genres,
        String posterUrl

) {

    public static MovieResponse fromMovie(Movie movie) {
        return new MovieResponse(
                movie.getId(),
                movie.getTitle(),
                movie.getDescription(),
                movie.getReleaseDate(),
                movie.getAverageRating(),
                movie.getGenres()
                        .stream()
                        .map(GENRE::toString)
                        .collect(Collectors.toSet()),
                movie.getPosterUrl()
        );
    }
}
