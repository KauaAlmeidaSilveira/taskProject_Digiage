package com.digiage.projectTask5.controllers;

import com.digiage.projectTask5.domain.user.User;
import com.digiage.projectTask5.dto.LoginRequestDTO;
import com.digiage.projectTask5.dto.RegisterRequestDTO;
import com.digiage.projectTask5.dto.ResponseDTO;
import com.digiage.projectTask5.infra.security.TokenService;
import com.digiage.projectTask5.repositories.UserRepository;
import com.digiage.projectTask5.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor //Evitando o uso de @Autowired, instanciando as dependências no construtor
public class AuthController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO loginRequest) {
        User user = userRepository.findByEmail(loginRequest.email()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        if (passwordEncoder.matches(loginRequest.senha(), user.getSenha())) {
            String token = tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        Optional<User> user = userRepository.findByEmail(registerRequestDTO.email());

        if (user.isEmpty()) {
            User newUser = new User();
            newUser.setNome(registerRequestDTO.nome());
            newUser.setEmail(registerRequestDTO.email());
            newUser.setSenha(passwordEncoder.encode(registerRequestDTO.senha()));
            this.userRepository.save(newUser);

            String token = tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getNome(), token));

        }
        return ResponseEntity.badRequest().build();
    }
}
