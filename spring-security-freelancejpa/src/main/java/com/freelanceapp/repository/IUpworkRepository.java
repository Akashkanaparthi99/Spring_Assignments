package com.freelanceapp.repository;

import com.freelanceapp.model.Upwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUpworkRepository extends JpaRepository<Upwork,Integer> {

    List<Upwork> findByPricePerHour(double pricePerHour);
    List<Upwork> findByExpertise(String expertise);
    List<Upwork> findByJobType(String jobType);
    List<Upwork> findByDuration(String duration);
    List<Upwork> findByJobName(String jobName);
    List<Upwork> findByCategory(String category);
    @Query("from Upwork u where u.jobName = ?1 and u.category = ?2")
    List<Upwork> findByJobNameAndCategory(String jobName,String Category);
    @Query("from Upwork u where u.category = ?1 and u.technologies = ?2")
    List<Upwork> findByCategoryAndTech(String category,String technology);
    @Query("from Upwork u where u.duration = ?1 and u.pricePerHour = ?2")
    List<Upwork> findByDurationAndPrice(String duration,double pricePerHour);
    @Query("from Upwork u where u.expertise = ?1 and u.pricePerHour = ?2")
    List<Upwork> findByExpertiseAndPrice(String expertise,double pricePerHour);
    @Query("from Upwork u where u.category = ?1 and u.expertise = ?2")
    List<Upwork> findByCategoryAndExpertise(String category,String expertise);
    @Query("from Upwork u where u.jobType = ?1 and u.category = ?2")
    List<Upwork> findByJobTypeAndCategory(String jobType,String category);
}
