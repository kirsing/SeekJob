package com.kirsing.seekjob.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users_type")
public class UsersType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userTypeId;

    private String userTypeName;


    @OneToMany(targetEntity = UsersType.class, mappedBy = "userTypeId",
            cascade = CascadeType.ALL)
    private List<Users> users;
}
