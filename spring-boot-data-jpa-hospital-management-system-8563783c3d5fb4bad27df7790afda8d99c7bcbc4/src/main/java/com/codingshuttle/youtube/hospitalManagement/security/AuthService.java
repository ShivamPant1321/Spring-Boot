package com.codingshuttle.youtube.hospitalManagement.security;


import com.codingshuttle.youtube.hospitalManagement.dto.LoginRequestdto;
import com.codingshuttle.youtube.hospitalManagement.dto.LoginResponsedto;
import com.codingshuttle.youtube.hospitalManagement.dto.SignUpResponsedto;
import com.codingshuttle.youtube.hospitalManagement.entity.User;
import com.codingshuttle.youtube.hospitalManagement.entity.type.AuthProviderType;
import com.codingshuttle.youtube.hospitalManagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
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

    public ResponseEntity<LoginResponsedto> handleOAuth2LoginRequest(OAuth2User oAuth2User, String registrationId) {
        // provider type and provider id
        // save the provider id and provider type info with user
        // if the user has an account: directly login
        // otherwise, first signup and then login

        AuthProviderType providerType = authUtil.getProviderTypeFromRegistrationId(registrationId);
        String providerId = authUtil.determineProviderIdFromOAuth2User(oAuth2User, registrationId);

        User user = userRepository.findByProviderIdAndProviderType(providerId, providerType).orElse(null);


    }
}
