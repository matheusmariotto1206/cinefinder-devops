package br.com.fiap.cinefinder_v3.service;

import br.com.fiap.cinefinder_v3.dto.CreateReviewDTO;
import br.com.fiap.cinefinder_v3.dto.ReviewResponse;
import br.com.fiap.cinefinder_v3.dto.UpdateReviewDTO;
import br.com.fiap.cinefinder_v3.model.Review;
import br.com.fiap.cinefinder_v3.repository.MovieRepo;
import br.com.fiap.cinefinder_v3.repository.ReviewRepo;
import br.com.fiap.cinefinder_v3.repository.UserRepo;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepo repo;
    private final MovieRepo movieRepo;
    private final UserRepo userRepo;

    public Page<ReviewResponse> getAll(Pageable pageable) {
        return repo.findAll(pageable).map(ReviewResponse::fromReview);
    }

    public ReviewResponse getById(Long id) {
        return repo.findById(id).map(ReviewResponse::fromReview).orElseThrow();
    }

    @Transactional
    public ReviewResponse create(@Valid CreateReviewDTO dto) {
        var movie = movieRepo.findById(dto.movieId())
                .orElseThrow();
        var user = userRepo.findById(dto.userId())
                .orElseThrow();

        var review = new Review();
        review.setMovie(movie);
        review.setUser(user);
        review.setRating(dto.rating());
        review.setComments(dto.comments());

        movie.addReview(review);

        return ReviewResponse.fromReview(
                repo.save(review)
        );
    }

    public ReviewResponse update(Long id, @Valid UpdateReviewDTO reviewDTO) {
        if (reviewDTO.isEmpty()) {
            throw new IllegalArgumentException("Algum dos campos deve ser alterado");
        }

        var review = repo.findById(id).orElseThrow();

        if (reviewDTO.comments() != null && !review.getComments().equalsIgnoreCase(reviewDTO.comments())) {

            review.setComments(reviewDTO.comments());
        }
        if (reviewDTO.rating() != null && !review.getRating().equals(reviewDTO.rating())) {

            review.setRating(reviewDTO.rating());
        }

        return ReviewResponse.fromReview(repo.save(review));

    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
