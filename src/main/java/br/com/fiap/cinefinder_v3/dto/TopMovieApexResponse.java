package br.com.fiap.cinefinder_v3.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record TopMovieApexResponse(
        Long id,
        String title,
        String genre,
        @JsonProperty("average_rating")
        BigDecimal averageRating,
        @JsonProperty("total_reviews")
        Integer totalReviews
) {
}
