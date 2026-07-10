package com.codingshuttle.youtube.hospitalManagement.security;

import com.codingshuttle.youtube.hospitalManagement.entity.User;
import com.codingshuttle.youtube.hospitalManagement.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;


@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final UserRepository userRepository;
    private final AuthUtil authUtil;

    private final HandlerExceptionResolver exceptionResolver;

    @Override
    public void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        try{
            log.info("Incoming request: "+req.getRequestURI());

            final String requestTokenHeader = req.getHeader("Authorization");
            if(requestTokenHeader == null && !requestTokenHeader.startsWith("Bearer ")) {
                chain.doFilter(req, res);
                return;
            }
            String token = requestTokenHeader.split("Bearer ")[1];
            String userName = authUtil.getUsernameFromToker(token);

            if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null){
                User user = userRepository.findByUsername(userName).orElseThrow();
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }

            chain.doFilter(req, res);
        } catch (Exception e) {
            exceptionResolver.resolveException(req, res, e, null);
        }
    }
}
