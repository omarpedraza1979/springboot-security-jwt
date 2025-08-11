package com.autenticacion.Auth;

import com.autenticacion.Jwt.JwtService;
import com.autenticacion.User.Role;
import com.autenticacion.User.User;
import com.autenticacion.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request){
        try {
            userRepository.findByUsername(request.getUsername())
                    .orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"));

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

            UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();

            String token = jwtService.getToken(user);

            return AuthResponse.builder()
                    .token(token)
                    .build();

        } catch (UsernameNotFoundException e) {
            System.out.println("Usuario no encontrado");
            throw new RuntimeException("El usuario no existe");

        } catch (BadCredentialsException e) {
            System.out.println("Contraseña incorrecta");
            throw new RuntimeException("Contraseña incorrecta");

        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            throw new RuntimeException("Error al intentar iniciar sesión");
        }

    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                        .username(request.getUsername())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .firstName(request.getFirstName())
                        .lastName(request.getLastName())
                        .country(request.getCountry())
                        .role(Role.USER)
                        .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();

    }
}