package com.codeOlogy.booktheshow.security;

import java.io.IOException;
import java.io.PrintWriter;

import  org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Aditya Ranjan
 * Youtube : @Code_O_logy
 * Website : blogsnax.com
 */


@Component
public class JWTEntryPoint implements AuthenticationEntryPoint{

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        // TODO Auto-generated method stub
        response.setStatus(HttpServletResponse .SC_UNAUTHORIZED);
        PrintWriter writer = response.getWriter();
        writer.println(" Access denied!! "+ authException.getMessage());
    }
    
}
