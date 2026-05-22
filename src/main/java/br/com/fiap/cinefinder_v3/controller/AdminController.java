package br.com.fiap.cinefinder_v3.controller;

import br.com.fiap.cinefinder_v3.model.User;
import br.com.fiap.cinefinder_v3.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/admin")
@RestController
@AllArgsConstructor
public class AdminController {

    private final UserRepo repo;

    @GetMapping
    public List<User> findAll() {
        return repo.findAll();
    }

}
