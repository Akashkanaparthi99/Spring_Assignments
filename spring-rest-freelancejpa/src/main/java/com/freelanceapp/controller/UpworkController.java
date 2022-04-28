package com.freelanceapp.controller;

import com.freelanceapp.exception.JobNotFoundException;
import com.freelanceapp.model.Upwork;
import com.freelanceapp.service.IUpworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/upwork-api")
public class UpworkController {
    private IUpworkService upworkService;
    @Autowired
    public void setUpworkService(IUpworkService upworkService) {
        this.upworkService = upworkService;
    }

    @PostMapping("/upworks")
    public Upwork addJob(@RequestBody Upwork upwork){
        return upworkService.addJob(upwork);
    }

    @PutMapping("/upworks")
    public void updateJob(@RequestBody Upwork upwork){
        upworkService.updateJob(upwork);
    }

    @DeleteMapping("/upworks/jobId/{jobid}")
    public void deleteJob(@PathVariable("jobid")int jobId){
        upworkService.deleteJob(jobId);
    }

    @GetMapping("/upworks")
    public List<Upwork> showJobs(){
        return upworkService.getAll();
    }

    @GetMapping("/upworks/pricePerHour/{price}")
    public List<Upwork> showByPrice(@PathVariable("price")double price) throws JobNotFoundException {
        return upworkService.getByPricePerHour(price);
    }

    @GetMapping("/upworks/category/{category}")
    public List<Upwork> showByCategory(@PathVariable("category")String category) throws JobNotFoundException {
        return upworkService.getByCategory(category);
    }
    @GetMapping("/upworks/expertise/{expertise}")
    public List<Upwork> showByExpert(@PathVariable("expertise")String expert) throws JobNotFoundException {
        return upworkService.getByExpertise(expert);
    }
    @GetMapping("/upworks/jobType/{jobType}")
    public List<Upwork> showByJobType(@PathVariable("jobType")String jobType) throws JobNotFoundException {
        return upworkService.getByJobType(jobType);
    }

    @GetMapping("/upworks/duration/{duration}")
    public List<Upwork> showByDuration(@PathVariable("duration")String duration) throws JobNotFoundException {
        return upworkService.getByDuration(duration);
    }

    @GetMapping("/upworks/jobName/{jobName}")
    public List<Upwork> showByJobName(@PathVariable("jobName")String jobName) throws JobNotFoundException {
        return upworkService.getByJobName(jobName);
    }

    @GetMapping("/upworks/jobName/{jobName}/category/{category}")
    public List<Upwork> showByJobAndCat(@PathVariable("jobName")String jobName,@PathVariable("category")String category) throws JobNotFoundException {
        return upworkService.getByJobNameAndCategory(jobName,category);
    }

    @GetMapping("/upworks/category/{category}/tech/{tech}")
    public List<Upwork> showByCatAndTech(@PathVariable("category")String category,@PathVariable("tech")String tech) throws JobNotFoundException {
        return upworkService.getByCategoryAndTech(category,tech);
    }

    @GetMapping("/upworks/duration/{duration}/price/{price}")
    public List<Upwork> showByDurationAndPrice(@PathVariable("duration")String duration,@PathVariable("price")double price) throws JobNotFoundException {
        return upworkService.getByDurationAndPrice(duration,price);
    }

    @GetMapping("/upworks/expert/{expert}/price/{price}")
    public List<Upwork> showByExpAndPrice(@PathVariable("expert")String expert,@PathVariable("price")double price) throws JobNotFoundException {
        return upworkService.getByExpertiseAndPrice(expert,price);
    }

    @GetMapping("/upworks/category/{category}/expert/{expert}")
    public List<Upwork> showByCatAndExp(@PathVariable("category")String category,@PathVariable("expert")String expert) throws JobNotFoundException {
        return upworkService.getByCategoryAndExpertise(category,expert);
    }

    @GetMapping("/upworks/job_type/{job}/category/{category}")
    public List<Upwork> showByJobTypeAndCat(@PathVariable("job")String jobType,@PathVariable("category")String category) throws JobNotFoundException {
        return upworkService.getByJobTypeAndCategory(jobType, category);
    }

}
