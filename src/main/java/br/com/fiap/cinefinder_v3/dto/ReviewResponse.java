package br.com.fiap.cinefinder_v3.dto;

import br.com.fiap.cinefinder_v3.model.Review;

import java.math.BigDecimal;

public record ReviewResponse(
        Long id,
        Long movieId,
        String movieTitle,
        String userName,
        BigDecimal rating,
        String comments
) {

    public static ReviewResponse fromReview(Review review) {
        return new ReviewResponse(
                review.getId(),
                review.getMovie().getId(),
                review.getMovie().getTitle(),
                review.getUser().getName(),
                review.getRating(),
                review.getComments()
        );
    }
}
