package br.com.fiap.cinefinder_v3.service;

import br.com.fiap.cinefinder_v3.dto.ApexTopMoviesWrapper;
import br.com.fiap.cinefinder_v3.dto.TopMovieApexResponse;
import br.com.fiap.cinefinder_v3.model.GENRE;
import br.com.fiap.cinefinder_v3.model.Movie;
import br.com.fiap.cinefinder_v3.repository.MovieRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ApexIntegrationService {

    private final RestClient restClient;
    private final String topMoviesUrl;
    private final MovieRepo movieRepo;

    public ApexIntegrationService(
            @Value("${apex.top-movies-url:https://oracleapex.com/ords/cinefinder/cinefinder/top-movies}")
            String topMoviesUrl,
            MovieRepo movieRepo
    ) {
        this.topMoviesUrl = topMoviesUrl;
        this.movieRepo = movieRepo;
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout((int) Duration.ofSeconds(8).toMillis());
        factory.setReadTimeout((int) Duration.ofSeconds(12).toMillis());
        this.restClient = RestClient.builder().requestFactory(factory).build();
    }

    public List<TopMovieApexResponse> getTopMovies() {
        try {
            List<TopMovieApexResponse> fromApex = fetchFromApex();
            if (!fromApex.isEmpty()) {
                log.info("Top movies carregados do Oracle APEX ({} itens)", fromApex.size());
                return fromApex;
            }
            log.warn("Oracle APEX retornou lista vazia, usando ranking do banco");
        } catch (RestClientException ex) {
            log.warn("Oracle APEX indisponível ({}), usando ranking do banco", ex.getMessage());
        }

        return fetchFromDatabase();
    }

    private List<TopMovieApexResponse> fetchFromApex() {
        log.info("Consultando Oracle APEX: {}", topMoviesUrl);
        ApexTopMoviesWrapper wrapper = restClient.get()
                .uri(topMoviesUrl)
                .retrieve()
                .body(ApexTopMoviesWrapper.class);

        if (wrapper == null || wrapper.items() == null) {
            return List.of();
        }
        return wrapper.items();
    }

    @Transactional(readOnly = true)
    public List<TopMovieApexResponse> fetchFromDatabase() {
        return movieRepo.findAll().stream()
                .filter(movie -> movie.getAverageRating() != null
                        && movie.getAverageRating().compareTo(BigDecimal.ZERO) > 0)
                .sorted(Comparator.comparing(Movie::getAverageRating).reversed())
                .limit(10)
                .map(movie -> new TopMovieApexResponse(
                        movie.getId(),
                        movie.getTitle(),
                        formatGenre(movie),
                        movie.getAverageRating(),
                        movie.getReviews() != null ? movie.getReviews().size() : 0
                ))
                .collect(Collectors.toList());
    }

    private String formatGenre(Movie movie) {
        if (movie.getGenres() == null || movie.getGenres().isEmpty()) {
            return "";
        }
        return movie.getGenres().stream()
                .map(GENRE::name)
                .collect(Collectors.joining(", "));
    }
}
