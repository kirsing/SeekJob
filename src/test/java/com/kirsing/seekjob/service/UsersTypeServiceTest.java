package com.kirsing.seekjob.service;

import com.kirsing.seekjob.entity.Users;
import com.kirsing.seekjob.entity.UsersType;
import com.kirsing.seekjob.integration.IntegrationTestBase;
import com.kirsing.seekjob.util.HibernateTestUtil;
import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor

class UsersTypeServiceTest extends IntegrationTestBase {

    private final SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory();

     @Autowired
    private UsersTypeService usersTypeService;


    @Test
    void findAll() {
        @Cleanup Session session = sessionFactory.openSession();

        session.beginTransaction();

        List<Users> results = usersTypeService.findAll(session);

        Assertions.assertThat(results).hasSize(10);


    }

    @Test
    void findUserByEmail() {
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Users> results = usersTypeService.findUserByEmail(session, "jonhaf@yahoo.com");
        assertThat(results).hasSize(1);
        assertThat(results.get(0).getEmail()).isEqualTo("jonhaf@yahoo.com");




    }

    @Test
    void findLimitedUsersOrderedByRegistrationDate() {
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();
        int limit = 3;
        List<Users> results = usersTypeService.findLimitedUsersOrderedByRegistrationDate(session, limit);
        assertThat(results).hasSize(limit);
    }

    @Test
    void findAllByUsersType() {
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Users> results = usersTypeService.findAllByUsersType(session, "Recruiter");
    }
}