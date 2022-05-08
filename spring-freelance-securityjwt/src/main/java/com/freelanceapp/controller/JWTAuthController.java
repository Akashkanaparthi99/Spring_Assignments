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

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JWTFreelancerServiceImpl freelancerService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody JWTFreelancer user){
        String username = user.getUsername();
        String password =  passwordEncoder.encode(user.getPassword());
        JWTFreelancer jwtUser = new JWTFreelancer(username,password);
        //save in db
        freelancerService.addUser(jwtUser);
        return ResponseEntity.ok("added");
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody JWTFreelancer jwtUser){
        // specify the type of authentication provider
        authenticate(jwtUser.getUsername(), jwtUser.getPassword());
        // check if username is in db
        UserDetails details = freelancerService.loadUserByUsername(jwtUser.getUsername());

        // generate the token with the userdata
        String token = jwtTokenUtil.generateToken(details);
        return ResponseEntity.ok(token);
    }

    // to specify the type of authentication
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
