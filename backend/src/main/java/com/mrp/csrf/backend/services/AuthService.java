package com.mrp.csrf.backend.services;

import com.mrp.csrf.backend.dtos.SignInDTO;
import com.mrp.csrf.backend.dtos.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    //senha aqui é password!
    private static final String HASH_PASSWORD = "$2y$10$yYo3ew3Oz9zakCylARCX5OeXnaZ2z1u/xx7mmDAxrTL.LJxaeRqwy";

    public UserDTO signIn(SignInDTO signInDTO) {
        if (passwordEncoder.matches(CharBuffer.wrap(signInDTO.password()), HASH_PASSWORD)) {
            // Se a senha for válida, retorna um UserDTO
            return new UserDTO(1L, "login", "Marcel");
        }
        // Caso a senha seja inválida, lança uma exceção
        throw new RuntimeException("Invalid password!!");
    }
}
