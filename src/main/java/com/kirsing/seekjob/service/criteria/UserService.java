package com.kirsing.seekjob.service.criteria;

import com.kirsing.seekjob.entity.Users;
import com.kirsing.seekjob.entity.UsersType;
import com.kirsing.seekjob.entity.UsersType_;
import com.kirsing.seekjob.entity.Users_;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("criteriaService")
@AllArgsConstructor
public class UserService {

    public List<Users> findAll(Session session) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Users> criteria = criteriaBuilder.createQuery(Users.class);
        Root<Users> users = criteria.from(Users.class);

        criteria.select(users);

        return session.createQuery(criteria).list();
    }

    public List<Users> findUserByEmail(Session session, String email) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Users> criteria = criteriaBuilder
                                        .createQuery(Users.class);
        Root<Users> users = criteria.from(Users.class);

        criteria.select(users).where(
                criteriaBuilder.equal(users.get(Users_.EMAIL), email)
        );
        return session.createQuery(criteria)
                .list();
    }

    public List<Users> findLimitedUsersOrderedByRegistrationDate(Session session, int limit) {
        var criteriaBuilder = session.getCriteriaBuilder();
        var criteria = criteriaBuilder.createQuery(Users.class);
        var users = criteria.from(Users.class);

        criteria.select(users).orderBy(
                criteriaBuilder.asc(users.get(Users_.REGISTRATION_DATE))
        );
        return session.createQuery(criteria)
                .setMaxResults(limit)
                .list();
    }

    public List<Users> findAllByUsersType(Session session, String userType) {
            var cb = session.getCriteriaBuilder();
            var criteria = cb.createQuery(Users.class);
            var users = criteria.from(Users.class);
            var types = users.join(UsersType_.USER_TYPE_ID);

            criteria.select(users)
                    .where(cb.equal(
                            types.get(UsersType_.USER_TYPE_NAME), userType));

            return session.createQuery(criteria).list();
    }

}

