package com.codingshuttle.youtube.hospitalManagement.security;


import com.codingshuttle.youtube.hospitalManagement.dto.LoginRequestdto;
import com.codingshuttle.youtube.hospitalManagement.dto.LoginResponsedto;
import com.codingshuttle.youtube.hospitalManagement.dto.SignUpResponsedto;
import com.codingshuttle.youtube.hospitalManagement.entity.User;
import com.codingshuttle.youtube.hospitalManagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginResponsedto login(LoginRequestdto loginRequestdto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestdto.getUsername(), loginRequestdto.getPassword())
        );

        User user = (User)authentication.getPrincipal();

        String token = authUtil.generateAccessToken(user);

        return new LoginResponsedto(token, user.getId());


    }

    public SignUpResponsedto signup(LoginRequestdto signUpRequestdto) {
        User user = userRepository.findByUsername(signUpRequestdto.getUsername()).orElse(null);

        if (user != null){
            throw new IllegalStateException("Username is already exists");
        }

        user = userRepository.save(User.builder().username(signUpRequestdto.getUsername()).password(passwordEncoder.encode(signUpRequestdto.getPassword())).build());

        return new SignUpResponsedto(user.getId(), user.getUsername());
    }
}
