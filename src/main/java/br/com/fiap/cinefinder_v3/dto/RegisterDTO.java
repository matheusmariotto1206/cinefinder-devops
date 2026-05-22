package br.com.fiap.cinefinder_v3.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterDTO(
        @NotBlank
        String name,
        @Email
        String email,
        @Size(min = 6)
        String password,
        @NotNull
        Integer age
) {
}
