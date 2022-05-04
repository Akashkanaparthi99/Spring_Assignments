package com.freelanceapp.controller;

import com.freelanceapp.model.AppUser;
import com.freelanceapp.service.IFreelancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppUserController {

    private PasswordEncoder passwordEncoder;
    private IFreelancerService freelancerService;
    @Autowired
    public void setFreelancerService(IFreelancerService freelancerService) {
        this.freelancerService = freelancerService;
    }
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/")
    public ResponseEntity<String> addUser(@RequestBody AppUser user){
        String username = user.getUsername();
        String password = passwordEncoder.encode(user.getPassword());
        AppUser appUser = new AppUser(username,password);
        freelancerService.addFreelancer(appUser);
        return ResponseEntity.ok("User added");
    }

    @PutMapping("/")
    public ResponseEntity<String> updateUser(@RequestBody AppUser user){
        int userId = user.getUserId();
        String username = user.getUsername();
        String password = passwordEncoder.encode(user.getPassword());
        AppUser appUser = new AppUser(userId,username,password);
        freelancerService.updateFreelancer(appUser);
        return ResponseEntity.ok("User updated");
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id")int userid){
        freelancerService.deleteFreelancer(userid);
        return ResponseEntity.ok("User has been deleted");
    }

}
