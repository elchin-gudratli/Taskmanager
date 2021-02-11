package com.taskmanager.taskmanager.security.filter;


import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taskmanager.taskmanager.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.util.StringUtils;
import com.taskmanager.taskmanager.entity.Users;
import com.taskmanager.taskmanager.service.impl.CustomUserDetailsService;
import com.taskmanager.taskmanager.service.impl.UsersServiceImpl;

import static com.taskmanager.taskmanager.security.SecurityConstants.HEADER_STRING;
import static com.taskmanager.taskmanager.security.SecurityConstants.TOKEN_PREFIX;
import io.jsonwebtoken.ExpiredJwtException;


public class JwtAuthenticationFilter extends OncePerRequestFilter {


	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	public JwtAuthenticationFilter() {
	}


	@Override
	    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
	                                    FilterChain filterChain) throws ServletException, IOException {

	        try {

	            String jwt = getJWTFromRequest(httpServletRequest);

	            if(StringUtils.hasText(jwt)&& JwtTokenProvider.getInstance().validateToken(jwt)){
	                String username = JwtTokenProvider.getInstance().getUsernameFromJWT(jwt);
	                Users usersDetails = customUserDetailsService.loadUsernameBy(username);

	                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
	                        usersDetails, null, Collections.emptyList());

	                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
	                SecurityContextHolder.getContext().setAuthentication(authentication);

	            }

	        }catch (Exception ex){
	            logger.error("Could not set user authentication in security context", ex);
	        }


	        filterChain.doFilter(httpServletRequest, httpServletResponse);

	    }



	    private String getJWTFromRequest(HttpServletRequest request){
	        String bearerToken = request.getHeader(HEADER_STRING);

	        if(StringUtils.hasText(bearerToken)&&bearerToken.startsWith(TOKEN_PREFIX)){
	            return bearerToken.substring(7, bearerToken.length());
	        }

	        return null;
	    }
}