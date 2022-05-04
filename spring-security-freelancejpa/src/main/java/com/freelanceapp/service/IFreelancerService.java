package com.freelanceapp.service;

import com.freelanceapp.model.AppUser;

public interface IFreelancerService {
    void addFreelancer(AppUser user);
    void updateFreelancer(AppUser user);
    void deleteFreelancer(int userId);
}
