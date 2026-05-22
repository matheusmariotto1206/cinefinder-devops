package br.com.fiap.cinefinder_v3.controller;

import br.com.fiap.cinefinder_v3.dto.CreateReviewDTO;
import br.com.fiap.cinefinder_v3.dto.ReviewResponse;
import br.com.fiap.cinefinder_v3.dto.UpdateReviewDTO;
import br.com.fiap.cinefinder_v3.service.ReviewService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
@AllArgsConstructor
@Log4j2
public class ReviewController {
    private final ReviewService service;

    @GetMapping
    public Page<ReviewResponse> getReviews(Pageable pageable) {
        log.info("Getting reviews");
        return service.getAll(pageable);
    }

    @GetMapping("/{id}")
    public ReviewResponse getReview(@PathVariable Long id) {
        log.info("Getting review with id: {}", id);
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewResponse createReview(@RequestBody CreateReviewDTO reviewDto) {
        log.info("Creating review: {}", reviewDto);
        return service.create(reviewDto);
    }

    @PutMapping("/{id}")
    public ReviewResponse updateReview(@PathVariable Long id,
                                       @RequestBody UpdateReviewDTO reviewDTO) {
        log.info("Updating review {}: {}", id, reviewDTO);
        return service.update(id, reviewDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        log.info("Deletando review de id: {}", id);
        service.delete(id);
    }


}
