package br.com.fiap.cinefinder_v3.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cf_movie_list")

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "cf_movie_list_movies",
            joinColumns = @JoinColumn(name = "movie_list_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    @Builder.Default
    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }

    public void removeMovie(Movie movie) {
        this.movies.remove(movie);
    }
}
