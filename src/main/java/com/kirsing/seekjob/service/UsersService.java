package com.kirsing.seekjob.service;


import com.kirsing.seekjob.entity.ApplicantProfile;
import com.kirsing.seekjob.entity.RecruiterProfile;
import com.kirsing.seekjob.entity.Users;
import com.kirsing.seekjob.repository.ApplicantRepository;
import com.kirsing.seekjob.repository.RecruiterRepository;
import com.kirsing.seekjob.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;
    private final ApplicantRepository applicantRepository;
    private final RecruiterRepository recruiterRepository;
    private final PasswordEncoder passwordEncoder;


    public Users addNewUser(Users user) {
        user.setActive(true);
        user.setRegistrationDate(LocalDateTime.now());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Users savedUser = usersRepository.save(user);
       int userTypeId = user.getUserTypeId().getUserTypeId();
        if (userTypeId == 1) {
            recruiterRepository.save(new RecruiterProfile(savedUser));
        } else {
            applicantRepository.save(new ApplicantProfile(savedUser));
        }
        return savedUser;

    }


    public Object getCurrentUserProfile() {
       Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();

       if (!(authentication instanceof AnonymousAuthenticationToken)) {
           String username = authentication.getName();
           Users users = usersRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Could not found " +
                   "user"));
          int userId = users.getUserId();
          if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("Recruiter"))) {
            RecruiterProfile recruiterProfile = recruiterRepository.findById(userId)
                                                        .orElse(new RecruiterProfile());
            return recruiterProfile;
          } else {
        ApplicantProfile applicantProfile = applicantRepository.findById(userId)
                                            .orElse(new ApplicantProfile());
        return applicantProfile;
          }
       }
       return null;
    }
}
