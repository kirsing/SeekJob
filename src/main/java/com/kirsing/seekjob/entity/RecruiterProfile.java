package com.kirsing.seekjob.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "recruiter_profile")
@Builder
public class RecruiterProfile {
    @Id
    private int userAccountId;
    @OneToOne
    @JoinColumn(name = "user_account_id")
    @MapsId
    private Users userId;


    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String country;
    private String company;
    @Column(nullable = true, length = 64)
    private String profilePhoto;

    public RecruiterProfile(Users user) {
        this.userId = user;
    }
}
