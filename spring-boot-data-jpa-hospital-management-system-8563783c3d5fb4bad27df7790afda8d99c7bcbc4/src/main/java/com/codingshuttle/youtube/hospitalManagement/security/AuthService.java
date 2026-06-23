package com.codingshuttle.youtube.hospitalManagement.security;


import com.codingshuttle.youtube.hospitalManagement.dto.LoginRequestdto;
import com.codingshuttle.youtube.hospitalManagement.dto.LoginResponsedto;
import com.codingshuttle.youtube.hospitalManagement.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;

    public LoginResponsedto login(LoginRequestdto loginRequestdto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestdto.getUsername(), loginRequestdto.getPassword())
        );

        User user = (User)authentication.getPrincipal();

        String token = authUtil.generateAccessToken(user);

        return new LoginResponsedto(token, user.getId());


    }
}
