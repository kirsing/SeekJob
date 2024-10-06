package com.kirsing.seekjob.hql.service;

import com.kirsing.seekjob.entity.Users;
import com.kirsing.seekjob.hql.integration.IntegrationTestBase;
import com.kirsing.seekjob.hql.util.HibernateTestUtil;
import com.kirsing.seekjob.service.hql.UserService;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RequiredArgsConstructor

class UserServiceTest extends IntegrationTestBase {

    private final SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory();

     @Autowired
    private UserService userService;


    @Test
    void findAll() {
        @Cleanup Session session = sessionFactory.openSession();

        session.beginTransaction();

        List<Users> results = userService.findAll(session);

        Assertions.assertThat(results).hasSize(10);


    }

    @Test
    void findUserByEmail() {
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Users> results = userService.findUserByEmail(session, "jonhaf@yahoo.com");
        assertThat(results).hasSize(1);
        assertThat(results.get(0).getEmail()).isEqualTo("jonhaf@yahoo.com");




    }

    @Test
    void findLimitedUsersOrderedByRegistrationDate() {
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();
        int limit = 3;
        List<Users> results = userService.findLimitedUsersOrderedByRegistrationDate(session, limit);
        assertThat(results).hasSize(limit);
    }

    @Test
    void findAllByUsersType() {
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Users> results = userService.findAllByUsersType(session, "Recruiter");
    }
}