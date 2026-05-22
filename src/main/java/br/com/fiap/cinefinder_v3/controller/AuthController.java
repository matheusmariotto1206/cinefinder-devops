package br.com.fiap.cinefinder_v3.controller;

import br.com.fiap.cinefinder_v3.dto.JwtResponse;
import br.com.fiap.cinefinder_v3.dto.LoginDTO;
import br.com.fiap.cinefinder_v3.dto.RegisterDTO;
import br.com.fiap.cinefinder_v3.dto.UserProfileResponse;
import org.springframework.security.core.Authentication;
import br.com.fiap.cinefinder_v3.exception.EmailAlreadyExists;
import br.com.fiap.cinefinder_v3.model.User;
import br.com.fiap.cinefinder_v3.repository.UserRepo;
import br.com.fiap.cinefinder_v3.service.JwtService;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepo userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthController(UserRepo userRepository,
                          PasswordEncoder passwordEncoder,
                          JwtService jwtService,
                          AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public JwtResponse register(@RequestBody @Valid RegisterDTO dto) {

        if (userRepository.findByEmail(dto.email()).isPresent()) {
            throw new EmailAlreadyExists("Email já cadastrado");
        }

        User user = User.builder()
                .name(dto.name())
                .email(dto.email())
                .password(passwordEncoder.encode(dto.password()))
                .age(dto.age())
                .isAdmin(false)
                .build();

        userRepository.save(user);

        return new JwtResponse(jwtService.generateToken(user.getEmail()));
    }

    @GetMapping("/me")
    public UserProfileResponse me(Authentication authentication) {
        User user = userRepository.findByEmail(authentication.getName())
                .orElseThrow();
        return UserProfileResponse.from(user);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginDTO dto) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.email(),
                        dto.password()
                )
        );

        return new JwtResponse(jwtService.generateToken(dto.email()));
    }

}
