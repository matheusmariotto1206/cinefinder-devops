package br.com.fiap.cinefinder_v3.repository;

import br.com.fiap.cinefinder_v3.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {
}
