package com.freelanceapp.service;

import com.freelanceapp.model.JWTFreelancer;
import com.freelanceapp.repository.JWTFreelancerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class JWTFreelancerServiceImpl implements UserDetailsService{

    private JWTFreelancerRepository freelancerRepository;
    @Autowired
    public void setFreelancerRepository(JWTFreelancerRepository freelancerRepository) {
        this.freelancerRepository = freelancerRepository;
    }

    /*
    * @author - Akash
    * @params - username
    * @return -
    *           this method returns the User Details by taking username
    *           throws exception if the username is not valid
    * */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JWTFreelancer user = freelancerRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Invalid Username");

        String nusername = user.getUsername();
        String password = user.getPassword();
        UserDetails userDetails = new User(nusername,password, Arrays.asList(new SimpleGrantedAuthority("ADMIN"),new SimpleGrantedAuthority("USER")));
        return userDetails;
    }
    /*
     * @author - Akash
     * @params - JWTFreelancer class (username,password)
     * @return -
     *           this method is used to add user
     * */
    public void addUser(JWTFreelancer user){
        freelancerRepository.save(user);
    }



}
