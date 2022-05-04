package com.freelanceapp.service;

import com.freelanceapp.model.AppUser;
import com.freelanceapp.repository.IFreelancerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class FreelancerServiceImpl implements UserDetailsService,IFreelancerService{

    private IFreelancerRepository freelancerRepository;
    @Autowired
    public void setFreelancerRepository(IFreelancerRepository freelancerRepository) {
        this.freelancerRepository = freelancerRepository;
    }

    @Override
    public void addFreelancer(AppUser user) {
        freelancerRepository.save(user);
    }

    @Override
    public void updateFreelancer(AppUser user) {
        freelancerRepository.save(user);
    }

    @Override
    public void deleteFreelancer(int userId) {
        freelancerRepository.deleteById(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = freelancerRepository.findByUsername(username);
        String nusername = appUser.getUsername();
        String password = appUser.getPassword();
        UserDetails userDetails = new User(nusername,password, Arrays.asList(new SimpleGrantedAuthority("ADMIN"),new SimpleGrantedAuthority("USER")));
        return userDetails;
    }
}
