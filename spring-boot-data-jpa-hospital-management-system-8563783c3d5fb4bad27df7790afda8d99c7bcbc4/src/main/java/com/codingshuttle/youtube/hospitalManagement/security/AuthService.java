package com.codingshuttle.youtube.hospitalManagement.security;


import com.codingshuttle.youtube.hospitalManagement.dto.LoginRequestdto;
import com.codingshuttle.youtube.hospitalManagement.dto.LoginResponsedto;
import com.codingshuttle.youtube.hospitalManagement.dto.SignUpResponsedto;
import com.codingshuttle.youtube.hospitalManagement.entity.Patient;
import com.codingshuttle.youtube.hospitalManagement.entity.SignUpRequestDto;
import com.codingshuttle.youtube.hospitalManagement.entity.User;
import com.codingshuttle.youtube.hospitalManagement.entity.type.AuthProviderType;
import com.codingshuttle.youtube.hospitalManagement.entity.type.RoleType;
import com.codingshuttle.youtube.hospitalManagement.repository.PatientRepository;
import com.codingshuttle.youtube.hospitalManagement.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PatientRepository patientRepository;

    public LoginResponsedto login(LoginRequestdto loginRequestdto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestdto.getUsername(), loginRequestdto.getPassword())
        );

        User user = (User)authentication.getPrincipal();

        String token = authUtil.generateAccessToken(user);

        return new LoginResponsedto(token, user.getId());


    }

    public User signUpInternal(SignUpRequestDto signUpRequestdto, AuthProviderType authProviderType, String providerId){
        User user = userRepository.findByUsername(signUpRequestdto.getUsername()).orElse(null);

        if (user != null){
            throw new IllegalStateException("Username is already exists");
        }

        user = User.builder().username(signUpRequestdto.getUsername()).providerId(providerId).authProviderType(authProviderType).roles(signUpRequestdto.getRoles()).build();
        if (authProviderType == AuthProviderType.EMAIL){
            user.setPassword(passwordEncoder.encode(signUpRequestdto.getPassword()));
        }

        user = userRepository.save(user);

        Patient patient = Patient.builder().name(signUpRequestdto.getName()).email(signUpRequestdto.getUsername()).user(user).build();

        patientRepository.save(patient);
        return user;
    }

    //login controller
    public SignUpResponsedto signup(SignUpRequestDto signUpRequestdto) {
        User user = signUpInternal(signUpRequestdto, AuthProviderType.EMAIL, null);
        return new SignUpResponsedto(user.getId(), user.getUsername());
    }

    @Transactional
    public ResponseEntity<LoginResponsedto> handleOAuth2LoginRequest(OAuth2User oAuth2User, String registrationId) {
        // provider type and provider id
        // save the provider id and provider type info with user
        // if the user has an account: directly login
        // otherwise, first signup and then login

        AuthProviderType authProviderType = authUtil.getProviderTypeFromRegistrationId(registrationId);
        String providerId = authUtil.determineProviderIdFromOAuth2User(oAuth2User, registrationId);

        User user = userRepository.findByProviderIdAndAuthProviderType(providerId, authProviderType).orElse(null);

        String email = oAuth2User.getAttribute("email");
        String name =  oAuth2User.getAttribute("name");

        User emailUser =  userRepository.findByUsername(email).orElse(null);

        if(user == null && emailUser == null){
            String username = authUtil.determineUsernameFromOAuth2User(oAuth2User, registrationId, providerId);
            user =signUpInternal(new SignUpRequestDto(username, null, name, Set.of(RoleType.PATIENT)), authProviderType, providerId);

        }else if(user != null){
            if(email != null && !email.isBlank() && !email.equals(user.getUsername())){
                user.setUsername(email);
                userRepository.save(user);
            }
        }else{
            throw new BadCredentialsException("This email is allready registered with provider: "+email);
        }

        LoginResponsedto loginResponsedto = new LoginResponsedto(authUtil.generateAccessToken(user), user.getId());

        return ResponseEntity.ok(loginResponsedto);

    }
}
