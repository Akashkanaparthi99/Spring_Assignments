package com.freelanceapp.repository;

import com.freelanceapp.controller.AppUserController;
import com.freelanceapp.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFreelancerRepository extends JpaRepository<AppUser,Integer> {
    AppUser findByUsername(String username);

}
