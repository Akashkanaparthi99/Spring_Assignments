package com.freelanceapp.controller;

import com.freelanceapp.model.JWTFreelancer;
import com.freelanceapp.service.JWTFreelancerServiceImpl;
import com.freelanceapp.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JWTAuthController {
    private PasswordEncoder passwordEncoder;
    private JWTFreelancerServiceImpl jwtFreelancerService;
    private JwtTokenUtil jwtTokenUtil;
    private AuthenticationManager authenticationManager;
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Autowired
    public void setJwtFreelancerService(JWTFreelancerServiceImpl jwtFreelancerService) {
        this.jwtFreelancerService = jwtFreelancerService;
    }
    @Autowired
    public void setJwtTokenUtil(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }




    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody JWTFreelancer jwtFreelancer){
        String username = jwtFreelancer.getUsername();
        String password = passwordEncoder.encode(jwtFreelancer.getPassword());
        JWTFreelancer freelancer = new JWTFreelancer(username,password);
        jwtFreelancerService.addUser(freelancer);
        return ResponseEntity.ok("Freelancer Added");
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody JWTFreelancer jwtFreelancer){
        authenticate(jwtFreelancer.getUsername(),jwtFreelancer.getPassword());
        UserDetails userDetails = jwtFreelancerService.loadUserByUsername(jwtFreelancer.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(token);
    }

    private void authenticate(String username,String password){
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            authenticationManager.authenticate(authenticationToken);
        }catch (BadCredentialsException e){
            System.out.println("Invalid Credentials");
        }catch (DisabledException e ){
            System.out.println("Disabled");
        }
    }
}
