package com.kirsing.seekjob.service;

import com.kirsing.seekjob.entity.Users;
import com.kirsing.seekjob.repository.UsersRepository;
import com.kirsing.seekjob.util.CustomUserDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class CustomUserDetailsService implements UserDetailsService {
    private final UsersRepository usersRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Users users = usersRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Could not find user " + username));
       return new CustomUserDetails(users);
    }
}
