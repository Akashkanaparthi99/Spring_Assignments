package com.freelanceapp.model;

import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue
    private Integer userId;
    @Column(unique = true)
    private String username;
    private String password;


    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
