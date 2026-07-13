package com.codingshuttle.youtube.hospitalManagement.security;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class WebSecurityConfig {

    private final PasswordEncoder passwordEncoder;
    private final JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity
                .csrf(csrfConfig -> csrfConfig.disable())
                .sessionManagement(sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(
                auth -> auth.requestMatchers("/public/**", "/auth/**").permitAll()
//                        .requestMatchers("/admin/**").hasRole("ADMIN")
//                        .requestMatchers("/doctors/**").hasAnyRole("DOCTOR", "ADMIN")
                        .anyRequest().authenticated()
                )
                .oauth2Login(oAuth2-> oAuth2.failureHandler((req, res, e) -> {
                    log.error("OAUTH2 failure occurred", e.getMessage());
                }).successHandler((req, res, auth) -> {

                }))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//                .formLogin(Customizer.withDefaults());
        return httpSecurity.build();
    }

//    @Bean
//    UserDetailsService userDetailsService(){
//        UserDetails user1 = User.withUsername("admin").password(passwordEncoder.encode("pass123")).roles("ADMIN").build();
//        UserDetails user2 = User.withUsername("doctor").password(passwordEncoder.encode("pass123")).roles("DOCTOR").build();
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }


}
