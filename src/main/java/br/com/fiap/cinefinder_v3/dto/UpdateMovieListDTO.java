package br.com.fiap.cinefinder_v3.dto;

import jakarta.validation.constraints.NotNull;

public record UpdateMovieListDTO(
        @NotNull
        String name
) {
}
