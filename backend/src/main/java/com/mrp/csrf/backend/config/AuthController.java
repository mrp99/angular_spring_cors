package com.mrp.csrf.backend.config;

import com.mrp.csrf.backend.dtos.SignInDTO;
import com.mrp.csrf.backend.dtos.UserDTO;
import com.mrp.csrf.backend.services.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final SecurityContextRepository repository = new HttpSessionSecurityContextRepository();

    @PostMapping("/signIn")
    public ResponseEntity<UserDTO> signIn(
            @RequestBody SignInDTO signInDTO,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
       UserDTO user = authService.signIn(signInDTO);
       SecurityContext context = SecurityContextHolder.getContext();
       context.setAuthentication(new UsernamePasswordAuthenticationToken(
               user,
               null,
               Collections.emptyList())
       );
       repository.saveContext(context, request, response);
       return ResponseEntity.ok(user);
    }
}
