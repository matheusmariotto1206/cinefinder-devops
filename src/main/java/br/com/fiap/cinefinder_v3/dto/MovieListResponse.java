package br.com.fiap.cinefinder_v3.dto;


import br.com.fiap.cinefinder_v3.model.MovieList;

import java.util.List;

public record MovieListResponse(
        Long id,
        String name,
        String userName,
        List<MovieResponse> movies
) {

    public static MovieListResponse fromMovieList(MovieList mList) {
        return new MovieListResponse(
                mList.getId(),
                mList.getName(),
                mList.getUser().getName(),
                mList.getMovies()
                        .stream()
                        .map(MovieResponse::fromMovie)
                        .toList()
        );
    }
}
