package com.freelanceapp.repository;

import com.freelanceapp.model.JWTFreelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JWTFreelancerRepository extends JpaRepository<JWTFreelancer,Integer> {
    JWTFreelancer findByUsername(String username);

}
