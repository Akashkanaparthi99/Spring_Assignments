package com.freelanceapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class JWTFreelancer {
    @Id
    @GeneratedValue
    private Integer userId;
    @Column(unique = true)
    private String username;
    private String password;

    public JWTFreelancer(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
