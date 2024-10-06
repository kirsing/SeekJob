package com.kirsing.seekjob.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.kirsing.seekjob.entity.UsersType;
import jdk.jfr.DataAmount;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer userId;


    @Column(unique = true)
    private String email;

    @NotEmpty
    private String password;

    private boolean isActive;

    @DateTimeFormat(pattern = "yy-MM-dd")
    private LocalDateTime registrationDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userTypeId", referencedColumnName = "userTypeId")
    private UsersType userTypeId;


    public Integer getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public @NotEmpty String getPassword() {
        return password;
    }

    public boolean isActive() {
        return isActive;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public UsersType getUserTypeId() {
        return userTypeId;
    }
}


