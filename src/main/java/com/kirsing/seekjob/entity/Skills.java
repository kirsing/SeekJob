package com.kirsing.seekjob.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "skills")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String experienceLevel;

    private String yearsOfExperience;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "applicant_profile")
    private ApplicantProfile applicantProfile;
}
