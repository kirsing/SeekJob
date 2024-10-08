package com.kirsing.seekjob.service;


import com.kirsing.seekjob.entity.ApplicantProfile;
import com.kirsing.seekjob.entity.RecruiterProfile;
import com.kirsing.seekjob.entity.Users;
import com.kirsing.seekjob.repository.ApplicantRepository;
import com.kirsing.seekjob.repository.RecruiterRepository;
import com.kirsing.seekjob.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;
    private final ApplicantRepository applicantRepository;
    private final RecruiterRepository recruiterRepository;

    public Users addNewUser(Users user) {
        user.setActive(true);
        user.setRegistrationDate(LocalDateTime.now());
        Users savedUser = usersRepository.save(user);
       int userTypeId = user.getUserTypeId().getUserTypeId();
        if (userTypeId == 1) {
            recruiterRepository.save(new RecruiterProfile(savedUser));
        } else {
            applicantRepository.save(new ApplicantProfile(savedUser));
        }
        return savedUser;

    }


}
