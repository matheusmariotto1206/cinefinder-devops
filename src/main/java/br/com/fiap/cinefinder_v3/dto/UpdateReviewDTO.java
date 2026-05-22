package br.com.fiap.cinefinder_v3.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;

public record UpdateReviewDTO(
        @Min(0)
        @Max(10)
        BigDecimal rating,
        String comments
) {

    public boolean isEmpty() {
        return rating == null && comments == null;
    }
}
