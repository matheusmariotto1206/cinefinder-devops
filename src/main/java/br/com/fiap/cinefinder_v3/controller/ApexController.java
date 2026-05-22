package br.com.fiap.cinefinder_v3.controller;

import br.com.fiap.cinefinder_v3.dto.TopMovieApexResponse;
import br.com.fiap.cinefinder_v3.service.ApexIntegrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/apex")
@AllArgsConstructor
public class ApexController {

    private final ApexIntegrationService apexIntegrationService;

    @GetMapping("/top-movies")
    public List<TopMovieApexResponse> topMovies() {
        return apexIntegrationService.getTopMovies();
    }
}
