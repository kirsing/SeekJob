package com.kirsing.seekjob.repository;

import com.kirsing.seekjob.entity.ApplicantProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<ApplicantProfile, Integer> {
}
