package com.kirsing.seekjob.repository;

import com.kirsing.seekjob.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
