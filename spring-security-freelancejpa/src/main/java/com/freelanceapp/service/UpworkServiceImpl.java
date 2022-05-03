package com.freelanceapp.service;

import com.freelanceapp.exception.JobNotFoundException;
import com.freelanceapp.model.Upwork;
import com.freelanceapp.repository.IUpworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UpworkServiceImpl implements IUpworkService{
    private IUpworkRepository upworkRepository;
    @Autowired
    public void setUpworkRepository(IUpworkRepository upworkRepository) {
        this.upworkRepository = upworkRepository;
    }

    @Override
    public Upwork addJob(Upwork upwork) {
        return upworkRepository.save(upwork);
    }

    @Override
    public void updateJob(Upwork upwork) {
        upworkRepository.save(upwork);
    }

    @Override
    public void deleteJob(int jobId) {
        upworkRepository.deleteById(jobId);
    }

    @Override
    public List<Upwork> getAll() {
        return upworkRepository.findAll();
    }

    @Override
    public List<Upwork> getByPricePerHour(double pricePerHour)  throws JobNotFoundException {
        List<Upwork> upworks = upworkRepository.findByPricePerHour(pricePerHour);
        if (upworks.isEmpty())
            throw new JobNotFoundException("No Job is Found");
        return upworkRepository.findByPricePerHour(pricePerHour);
    }

    @Override
    public List<Upwork> getByExpertise(String expertise) throws JobNotFoundException{
        List<Upwork> upworks = upworkRepository.findByExpertise(expertise)
                .stream().sorted(Comparator.comparing(Upwork::getJobName)).collect(Collectors.toList());
        if (upworks.isEmpty())
            throw new JobNotFoundException("No Job is Found");
        return upworks;
    }

    @Override
    public List<Upwork> getByJobType(String jobType) throws JobNotFoundException {
        List<Upwork> upworks =  upworkRepository.findByJobType(jobType).stream().sorted(Comparator.comparing(Upwork::getJobName)).collect(Collectors.toList());
        if (upworks.isEmpty())
            throw new JobNotFoundException("No Job is Found");
        return upworks;
    }

    @Override
    public List<Upwork> getByDuration(String duration) throws JobNotFoundException {
        List<Upwork> upworks =  upworkRepository.findByDuration(duration).stream().sorted(Comparator.comparing(Upwork::getJobName)).collect(Collectors.toList());
        if (upworks.isEmpty())
            throw new JobNotFoundException("No Job is Found");
        return upworks;
    }

    @Override
    public List<Upwork> getByJobName(String jobName) throws JobNotFoundException {
        List<Upwork> upworks =  upworkRepository.findByJobName(jobName).stream().sorted(Comparator.comparing(Upwork::getJobName)).collect(Collectors.toList());
        if (upworks.isEmpty())
            throw new JobNotFoundException("No Job is Found");
        return upworks;
    }

    @Override
    public List<Upwork> getByCategory(String category) throws JobNotFoundException {
        List<Upwork> upworks =  upworkRepository.findByCategory(category).stream().sorted(Comparator.comparing(Upwork::getJobName)).collect(Collectors.toList());
        if (upworks.isEmpty())
            throw new JobNotFoundException("No Job is Found");
        return upworks;
    }

    @Override
    public List<Upwork> getByJobNameAndCategory(String jobName, String Category) throws JobNotFoundException {
        List<Upwork> upworks =  upworkRepository.findByJobNameAndCategory(jobName, Category).stream().sorted(Comparator.comparing(Upwork::getJobName)).collect(Collectors.toList());

        if (upworks.isEmpty())
            throw new JobNotFoundException("No Job is Found");
        return upworks;
    }

    @Override
    public List<Upwork> getByCategoryAndTech(String category, String technology) throws JobNotFoundException {
        List<Upwork> upworks =  upworkRepository.findByCategoryAndTech(category,technology).stream().sorted(Comparator.comparing(Upwork::getJobName)).collect(Collectors.toList());
        if (upworks.isEmpty())
            throw new JobNotFoundException("No Job is Found");
        return upworks;
    }

    @Override
    public List<Upwork> getByDurationAndPrice(String duration, double pricePerHour) throws JobNotFoundException {
        List<Upwork> upworks =  upworkRepository.findByDurationAndPrice(duration, pricePerHour).stream().sorted(Comparator.comparing(Upwork::getJobName)).collect(Collectors.toList());
        if (upworks.isEmpty())
            throw new JobNotFoundException("No Job is Found");
        return upworks;
    }

    @Override
    public List<Upwork> getByExpertiseAndPrice(String expertise, double pricePerHour) throws JobNotFoundException {
        List<Upwork> upworks =  upworkRepository.findByExpertiseAndPrice(expertise, pricePerHour).stream().sorted(Comparator.comparing(Upwork::getJobName)).collect(Collectors.toList());
        if (upworks.isEmpty())
            throw new JobNotFoundException("No Job is Found");
        return upworks;
    }

    @Override
    public List<Upwork> getByCategoryAndExpertise(String category, String expertise) throws JobNotFoundException {
        List<Upwork> upworks =  upworkRepository.findByCategoryAndExpertise(category,expertise).stream().sorted(Comparator.comparing(Upwork::getJobName)).collect(Collectors.toList());
        if (upworks.isEmpty())
            throw new JobNotFoundException("No Job is Found");
        return upworks;
    }

    @Override
    public List<Upwork> getByJobTypeAndCategory(String jobType, String category) throws JobNotFoundException {
        List<Upwork> upworks =  upworkRepository.findByJobTypeAndCategory(jobType,category).stream().sorted(Comparator.comparing(Upwork::getJobName)).collect(Collectors.toList());
        if (upworks.isEmpty())
            throw new JobNotFoundException("No Job is Found");
        return upworks;
    }

}
