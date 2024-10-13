package com.kirsing.seekjob.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.kirsing.seekjob.entity.UsersType;
import jdk.jfr.DataAmount;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Data
public class Users {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}




