package br.com.fiap.cinefinder_v3.config;

import br.com.fiap.cinefinder_v3.dto.ErrorResponse;
import br.com.fiap.cinefinder_v3.exception.EmailAlreadyExists;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(Exception ex, HttpServletRequest request) {
        return buildResponse(ex, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({IllegalArgumentException.class, EmailAlreadyExists.class})
    public ResponseEntity<ErrorResponse> handleBadRequest(Exception ex, HttpServletRequest request) {
        return buildResponse(ex, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationError(MethodArgumentNotValidException ex, HttpServletRequest request) {
        var status = HttpStatus.BAD_REQUEST;

        var error = new ErrorResponse(
                LocalDateTime.now(),
                status.value(),
                ex.getClass().getSimpleName(),
                ex.getBindingResult()
                        .getFieldErrors()
                        .stream().map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                        .toList()
                        .toString(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex, HttpServletRequest request) {
        return buildResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    private ResponseEntity<ErrorResponse> buildResponse(Exception ex, HttpStatus status, HttpServletRequest request) {
        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),
                status.value(),
                ex.getClass().getSimpleName(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(error);
    }
}