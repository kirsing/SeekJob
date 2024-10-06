package com.kirsing.seekjob.hql.util;

import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@UtilityClass
public class HibernateTestUtil {
    public static SessionFactory buildSessionFactory() {
        Configuration configuration = HibernateUtil.buildConfiguration();
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5433/seekjob");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "mysecretpassword");
        configuration.configure();
        return configuration.buildSessionFactory();
    }
}
