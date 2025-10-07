package dev.Cursos.cursos.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.Cursos.cursos.User.Role;
import dev.Cursos.cursos.User.UserMapper;
import dev.Cursos.cursos.User.UserModel;
import dev.Cursos.cursos.User.UserRepository;
import dev.Cursos.cursos.User.dto.UserRequestDTO;
import dev.Cursos.cursos.auth.dto.AuthResponseDTO;
import dev.Cursos.cursos.auth.dto.LoginRequestDTO;
import dev.Cursos.cursos.jwt.JwtService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper; 

    public AuthResponseDTO register(UserRequestDTO dto) {
        if (userRepository.existsByEmail(dto.email())) {
            throw new RuntimeException("Email já cadastrado");
        }
        UserModel user = userMapper.toModel(dto);
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setRole(Role.USER);
        UserModel saved = userRepository.save(user);
        String token = jwtService.generateToken(saved);
        return new AuthResponseDTO(saved.getEmail(), token);
    }

    public AuthResponseDTO login(LoginRequestDTO dto) {
        var authToken = new UsernamePasswordAuthenticationToken(dto.email(), dto.password());
        authenticationManager.authenticate(authToken); 

        UserModel user = userRepository.findByEmail(dto.email())
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        String token = jwtService.generateToken(user);
        return new AuthResponseDTO(user.getEmail(), token);
    }
}