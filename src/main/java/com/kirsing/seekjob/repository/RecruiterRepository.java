package com.kirsing.seekjob.repository;

import com.kirsing.seekjob.entity.RecruiterProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruiterRepository extends JpaRepository<RecruiterProfile, Integer> {
}
