package com.kirsing.seekjob.service;

import com.kirsing.seekjob.entity.Users;
import com.kirsing.seekjob.integration.IntegrationTestBase;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
class UsersTypeServiceTest extends IntegrationTestBase {

   private final UsersTypeService usersTypeService;


    @Test
    void findAll() {


        List<Users> result = usersTypeService.findAll();

    }

    @Test
    void findUserByEmail() {
    }

    @Test
    void findLimitedUsersOrderedByRegistrationDate() {
    }

    @Test
    void findAllByUsersType() {
    }
}