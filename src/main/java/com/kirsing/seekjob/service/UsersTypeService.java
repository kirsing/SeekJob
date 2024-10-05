package com.kirsing.seekjob.service;

import com.kirsing.seekjob.entity.UsersType;
import com.kirsing.seekjob.repository.UsersTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsersTypeService {
    private final UsersTypeRepository usersTypeRepository;


    public List<UsersType> findAll() {
        return usersTypeRepository.findAll();
    }
}
