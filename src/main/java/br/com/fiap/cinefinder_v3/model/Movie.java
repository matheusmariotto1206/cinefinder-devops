package br.com.fiap.cinefinder_v3.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cf_movie")

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    private String description;

    private LocalDate releaseDate;

    private String posterUrl;

    @Min(0)
    @Max(10)
    private BigDecimal averageRating;

    @ElementCollection(targetClass = GENRE.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "cf_movie_genres", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "genre")
    @Builder.Default
    private Set<GENRE> genres = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    public void addGenre(GENRE genre) {
        this.genres.add(genre);
    }

    public void removeGenre(GENRE genre) {
        this.genres.remove(genre);
    }

    public void addReview(Review review) {
        review.setMovie(this);
        this.reviews.add(review);
        updateRate();
    }

    private void updateRate() {
         if (this.reviews.isEmpty()) {
             this.averageRating = BigDecimal.ZERO;
             return;
         }

        var sum = reviews.stream()
                .map(Review::getRating)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        this.averageRating = sum.divide(
                BigDecimal.valueOf(reviews.size()),
                2,
                RoundingMode.HALF_UP);
    }


}
