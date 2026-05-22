package br.com.fiap.cinefinder_v3.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EmailAlreadyExists extends RuntimeException {
    private String message;
}
