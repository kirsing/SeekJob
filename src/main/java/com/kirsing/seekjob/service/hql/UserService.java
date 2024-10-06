package com.kirsing.seekjob.service.hql;

import com.kirsing.seekjob.entity.Users;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("hqlService")
@AllArgsConstructor
public class UserService {

    public List<Users> findAll(Session session) {
        return session.createQuery("select u from Users u", Users.class)
                .list();
    }

    public List<Users> findUserByEmail(Session session, String email) {
        return session.createQuery("select u from Users u " +
                "where u.email = :email", Users.class)
                .setParameter("email", email)
                .list();
    }

    public List<Users> findLimitedUsersOrderedByRegistrationDate(Session session, int limit) {
        return session.createQuery("select u from Users u order by u.registrationDate", Users.class)
                .setMaxResults(limit)
                .list();
    }

    public List<Users> findAllByUsersType(Session session, String userType) {
        return session.createQuery("select u from Users u " +
                "join u.userTypeId ust "
                + "where ust.userTypeName = :userType", Users.class)
                .setParameter("userType", userType)
                .list();
    }

    }

