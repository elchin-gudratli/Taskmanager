package com.taskmanager.taskmanager.controller;


import javax.validation.Valid;

import com.taskmanager.taskmanager.payload.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.taskmanager.service.impl.MapValidationErrorService;
import com.taskmanager.taskmanager.service.impl.UsersServiceImpl;
import com.taskmanager.taskmanager.validator.UserValidator;
import com.taskmanager.taskmanager.payload.LoginRequest;
import com.taskmanager.taskmanager.entity.Users;
import com.taskmanager.taskmanager.payload.JWTLoginSuccessResponse;
import com.taskmanager.taskmanager.security.JwtTokenProvider;

import static com.taskmanager.taskmanager.security.SecurityConstants.TOKEN_PREFIX;;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private UsersServiceImpl userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;



    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = TOKEN_PREFIX +  tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTLoginSuccessResponse(true, jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRequest userRequest, BindingResult result){
   
        userValidator.validate(userRequest,result);

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null)return errorMap;
        Users newUsers = userService.saveUser(userRequest);

        return  new ResponseEntity<Users>(newUsers, HttpStatus.CREATED);
    }
}
