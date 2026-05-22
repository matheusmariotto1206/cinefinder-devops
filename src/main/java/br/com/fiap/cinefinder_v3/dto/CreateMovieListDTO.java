package br.com.fiap.cinefinder_v3.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateMovieListDTO(
        @NotBlank
        String name,
        @NotNull
        Long userId
) {
}
