package com.freelanceapp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Upwork {
    @Column(name = "jobid")
    @Id
    @GeneratedValue(generator = "upwork_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "upwork_gen",sequenceName = "upwork_sequence",initialValue = 5,allocationSize = 10)
    @ToString.Exclude
    private Integer jobId;
    @Column(length = 40)
    private String jobName;
    @Column(length = 40)
    private String category;// marketing,developing...
    @Column(length = 40)
    private String duration; // project duration
    @Column(length = 40)
    private String technologies;
    @Column(length = 40)
    private double pricePerHour;
    @Column(length = 40)
    private String expertise; // beginner, intermediate, expert
    @Column(length = 40)
    private String jobType; // oneTime/recurring
    private String description;

    public Upwork(String jobName, String category, String duration, String technologies, double pricePerHour, String expertise, String jobType, String description) {
        this.jobName = jobName;
        this.category = category;
        this.duration = duration;
        this.technologies = technologies;
        this.pricePerHour = pricePerHour;
        this.expertise = expertise;
        this.jobType = jobType;
        this.description = description;
    }
}
