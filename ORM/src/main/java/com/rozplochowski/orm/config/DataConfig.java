package com.rozplochowski.orm.config;

import com.rozplochowski.orm.domain.Course;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.JdbcSettings;
import org.hibernate.cfg.SchemaToolingSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DataConfig {

//    @Bean
//    EntityManagerFactory entityManagerFactory() {
//        var cfg = new org.hibernate.cfg.Configuration()
//                .addAnnotatedClass(Course.class)
//                .setProperty(JdbcSettings.JAKARTA_JDBC_URL, "jdbc:h2:mem:test")
//                .setProperty(JdbcSettings.JAKARTA_JDBC_PASSWORD, "")
//                .setProperty(JdbcSettings.JAKARTA_JDBC_USER, "sa")
//                .setProperty(SchemaToolingSettings.HBM2DDL_AUTO, "create")
//                .showSql(true, true, true);
//        return cfg.buildSessionFactory();
//    }
 }
