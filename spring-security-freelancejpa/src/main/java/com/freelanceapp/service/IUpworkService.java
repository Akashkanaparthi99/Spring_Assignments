package com.freelanceapp.service;

import com.freelanceapp.exception.JobNotFoundException;
import com.freelanceapp.model.Upwork;

import java.util.List;

public interface IUpworkService {

    Upwork addJob(Upwork upwork);
    void updateJob(Upwork upwork);
    void deleteJob(int jobId);

    List<Upwork> getAll();
    List<Upwork> getByPricePerHour(double pricePerHour) throws JobNotFoundException;
    List<Upwork> getByExpertise(String expertise) throws JobNotFoundException;
    List<Upwork> getByJobType(String jobType) throws JobNotFoundException;
    List<Upwork> getByDuration(String duration) throws JobNotFoundException;
    List<Upwork> getByJobName(String jobName) throws JobNotFoundException;
    List<Upwork> getByCategory(String category) throws JobNotFoundException;
    List<Upwork> getByJobNameAndCategory(String jobName,String Category) throws JobNotFoundException;
    List<Upwork> getByCategoryAndTech(String category,String technology) throws JobNotFoundException;
    List<Upwork> getByDurationAndPrice(String duration,double pricePerHour) throws JobNotFoundException;
    List<Upwork> getByExpertiseAndPrice(String expertise,double pricePerHour) throws JobNotFoundException;
    List<Upwork> getByCategoryAndExpertise(String category,String expertise) throws JobNotFoundException;
    List<Upwork> getByJobTypeAndCategory(String jobType,String category) throws JobNotFoundException;
}
