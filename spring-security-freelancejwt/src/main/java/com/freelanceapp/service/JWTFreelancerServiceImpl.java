package com.freelanceapp.service;

import com.freelanceapp.model.JWTFreelancer;
import com.freelanceapp.repository.JWTFreelancerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class JWTFreelancerServiceImpl implements UserDetailsService {

    private JWTFreelancerRepository jwtFreelancerRepository;
    @Autowired
    public void setJwtFreelancerRepository(JWTFreelancerRepository jwtFreelancerRepository) {
        this.jwtFreelancerRepository = jwtFreelancerRepository;
    }

    public void addUser(JWTFreelancer freelancer){
        jwtFreelancerRepository.save(freelancer);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JWTFreelancer freelancer = jwtFreelancerRepository.findByUsername(username);
        if (freelancer == null)
            throw new UsernameNotFoundException("Invalid Username");

        List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ADMIN"),new SimpleGrantedAuthority("USER"));
        UserDetails userDetails = new User(freelancer.getUsername(),freelancer.getPassword(),authorities);

        return userDetails;
    }
}
