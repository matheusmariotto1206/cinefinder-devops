package br.com.fiap.cinefinder_v3.service;

import br.com.fiap.cinefinder_v3.dto.CreateMovieListDTO;
import br.com.fiap.cinefinder_v3.dto.MovieListResponse;
import br.com.fiap.cinefinder_v3.dto.UpdateMovieListDTO;
import br.com.fiap.cinefinder_v3.model.MovieList;
import br.com.fiap.cinefinder_v3.repository.MovieListRepo;
import br.com.fiap.cinefinder_v3.repository.MovieRepo;
import br.com.fiap.cinefinder_v3.repository.UserRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieListService {

    private final MovieListRepo repo;
    private final UserRepo userRepo;
    private final MovieRepo movieRepo;

    public Page<MovieListResponse> getAllMovieLists(Pageable pageable) {
        return repo.findAll(pageable).map(MovieListResponse::fromMovieList);
    }

    public MovieListResponse getById(Long id) {
        return MovieListResponse.fromMovieList(repo.findById(id).orElseThrow());
    }

    public MovieListResponse create(@Valid CreateMovieListDTO movieList) {
        var user = userRepo.findById(movieList.userId()).orElseThrow();
        var newMList = new MovieList();

        newMList.setName(movieList.name());
        newMList.setUser(user);

        return MovieListResponse.fromMovieList(repo.save(newMList));
    }

    public MovieListResponse update(Long id, @Valid UpdateMovieListDTO movieList) {
        if (movieList.name() == null || movieList.name().isEmpty()) {
            throw new IllegalArgumentException("Insira um nome válido para alterar");
        }

        var mList = repo.findById(id).orElseThrow();

        if (!mList.getName().equals(movieList.name())) {
            mList.setName(movieList.name());
        }

        return MovieListResponse.fromMovieList(repo.save(mList));
    }

    public void delete(Long id) {
        var mList = repo.findById(id).orElseThrow();
        repo.delete(mList);
    }

    public MovieListResponse addMovieToList(Long id, Long movieId) {
        var mList = repo.findById(id).orElseThrow();
        var movie = movieRepo.findById(movieId).orElseThrow();
        mList.addMovie(movie);
        return MovieListResponse.fromMovieList(repo.save(mList));
    }

    public MovieListResponse removeMovieToList(Long id, Long movieId) {
        var mList = repo.findById(id).orElseThrow();
        boolean removed = mList.getMovies().removeIf(m -> movieId.equals(m.getId()));
        if (!removed) {
            throw new java.util.NoSuchElementException("Filme não está nesta lista");
        }
        return MovieListResponse.fromMovieList(repo.save(mList));
    }

}
