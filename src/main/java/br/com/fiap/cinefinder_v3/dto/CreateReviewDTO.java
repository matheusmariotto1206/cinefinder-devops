package br.com.fiap.cinefinder_v3.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateReviewDTO(
        @NotNull
        Long userId,
        @NotNull
        Long movieId,
        @Min(value = 0)
        @Max(value = 10)
        BigDecimal rating,
        String comments
) {
}
