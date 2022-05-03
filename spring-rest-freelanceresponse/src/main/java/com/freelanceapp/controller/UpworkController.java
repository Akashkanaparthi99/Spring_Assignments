package com.freelanceapp.controller;

import com.freelanceapp.exception.JobNotFoundException;
import com.freelanceapp.model.Upwork;
import com.freelanceapp.service.IUpworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Upwork> addJob(@RequestBody Upwork upwork){
        upworkService.addJob(upwork);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/upworks")
    public ResponseEntity<Void> updateJob(@RequestBody Upwork upwork){
        upworkService.updateJob(upwork);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/upworks/jobId/{jobid}")
    public ResponseEntity<Void> deleteJob(@PathVariable("jobid")int jobId){
        upworkService.deleteJob(jobId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/upworks")
    public ResponseEntity<List<Upwork>> showJobs(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","All Available Jobs");
        return ResponseEntity.ok().headers(headers).body(upworkService.getAll());
    }

    @GetMapping("/upworks/pricePerHour/{price}")
    public ResponseEntity<List<Upwork>> showByPrice(@PathVariable("price")double price) throws JobNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Jobs by Price");
        return ResponseEntity.ok().headers(headers).body(upworkService.getByPricePerHour(price));

    }

    @GetMapping("/upworks/category/{category}")
    public ResponseEntity<List<Upwork>> showByCategory(@PathVariable("category")String category) throws JobNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Jobs by Price");
        return ResponseEntity.ok().headers(headers).body(upworkService.getByCategory(category));
    }
    @GetMapping("/upworks/expertise/{expertise}")
    public ResponseEntity<List<Upwork>> showByExpert(@PathVariable("expertise")String expert) throws JobNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Jobs by Price");
        return ResponseEntity.ok().headers(headers).body(upworkService.getByExpertise(expert));
    }
    @GetMapping("/upworks/jobType/{jobType}")
    public ResponseEntity<List<Upwork>> showByJobType(@PathVariable("jobType")String jobType) throws JobNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Jobs by Price");
        return ResponseEntity.ok().headers(headers).body(upworkService.getByJobType(jobType));
    }

    @GetMapping("/upworks/duration/{duration}")
    public ResponseEntity<List<Upwork>> showByDuration(@PathVariable("duration")String duration) throws JobNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Jobs by Price");
        return ResponseEntity.ok().headers(headers).body(upworkService.getByDuration(duration));
    }

    @GetMapping("/upworks/jobName/{jobName}")
    public ResponseEntity<List<Upwork>> showByJobName(@PathVariable("jobName")String jobName) throws JobNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Jobs by Price");
        return ResponseEntity.ok().headers(headers).body(upworkService.getByJobName(jobName));
    }

    @GetMapping("/upworks/jobName/{jobName}/category/{category}")
    public ResponseEntity<List<Upwork>> showByJobAndCat(@PathVariable("jobName")String jobName,@PathVariable("category")String category) throws JobNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Jobs by Price");
        return ResponseEntity.ok().headers(headers).body(upworkService.getByJobNameAndCategory(jobName,category));
    }

    @GetMapping("/upworks/category/{category}/tech/{tech}")
    public ResponseEntity<List<Upwork>> showByCatAndTech(@PathVariable("category")String category,@PathVariable("tech")String tech) throws JobNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Jobs by Price");
        return ResponseEntity.ok().headers(headers).body(upworkService.getByCategoryAndTech(category, tech));
    }
    @GetMapping("/upworks/duration/{duration}/price/{price}")
    public ResponseEntity<List<Upwork>> showByDurationAndPrice(@PathVariable("duration")String duration,@PathVariable("price")double price) throws JobNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Jobs by Price");
        return ResponseEntity.ok().headers(headers).body(upworkService.getByDurationAndPrice(duration,price));
    }

    @GetMapping("/upworks/expert/{expert}/price/{price}")
    public ResponseEntity<List<Upwork>> showByExpAndPrice(@PathVariable("expert")String expert,@PathVariable("price")double price) throws JobNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Jobs by Price");
        return ResponseEntity.ok().headers(headers).body(upworkService.getByExpertiseAndPrice(expert,price));
    }

    @GetMapping("/upworks/category/{category}/expert/{expert}")
    public ResponseEntity<List<Upwork>> showByCatAndExp(@PathVariable("category")String category,@PathVariable("expert")String expert) throws JobNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Jobs by Price");
        return ResponseEntity.ok().headers(headers).body(upworkService.getByCategoryAndExpertise(category,expert));
    }

    @GetMapping("/upworks/job_type/{job}/category/{category}")
    public ResponseEntity<List<Upwork>> showByJobTypeAndCat(@PathVariable("job")String jobType,@PathVariable("category")String category) throws JobNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Jobs by Price");
        return ResponseEntity.ok().headers(headers).body(upworkService.getByJobTypeAndCategory(jobType, category));
    }

}
