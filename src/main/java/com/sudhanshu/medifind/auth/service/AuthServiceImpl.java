package com.sudhanshu.medifind.auth.service;

import com.sudhanshu.medifind.auth.dto.LoginRequest;
import com.sudhanshu.medifind.auth.dto.LoginResponse;
import com.sudhanshu.medifind.auth.jwt.JwtService;
import com.sudhanshu.medifind.entity.User;
import com.sudhanshu.medifind.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class AuthServiceImpl implements AuthService{
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public AuthServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }
    @Override
    public LoginResponse login(LoginRequest request) {
        Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());

        if(optionalUser.isEmpty()){
            throw new RuntimeException("Invalid email or password");
        }
        User user = optionalUser.get();

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }
        String token = jwtService.generateToken(user);

        LoginResponse response = new LoginResponse();
        response.setToken(token);
        return response;
    }
}
