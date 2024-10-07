package com.kirsing.seekjob.service;


import com.kirsing.seekjob.entity.Users;
import com.kirsing.seekjob.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;
    

    public Users addNewUser(Users user) {
        user.setActive(true);
        user.setRegistrationDate(LocalDateTime.now());
        return usersRepository.save(user);

    }


}
