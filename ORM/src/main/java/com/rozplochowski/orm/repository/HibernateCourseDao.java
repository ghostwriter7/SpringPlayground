package com.rozplochowski.orm.repository;

import com.rozplochowski.orm.domain.Course;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class HibernateCourseDao implements CourseDao {

    private final SessionFactory sessionFactory;

    HibernateCourseDao(EntityManagerFactory entityManagerFactory) {
        this.sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
    }

    @Override
    public Course store(Course course) {
        var session = sessionFactory.openSession();
        try (session) {
            session.beginTransaction();

            if (course.getId() == null) {
                session.persist(course);
            } else {
                session.merge(course);
            }

            session.getTransaction().commit();
            return course;
        } catch (RuntimeException ex) {
            session.getTransaction().rollback();
            throw ex;
        }
    }

    @Override
    public Course findById(Long id) {
        try (var session = sessionFactory.openSession()) {
            return session.find(Course.class, id);
        }
    }

    @Override
    public void delete(Long courseId) {
        var session = sessionFactory.openSession();
        try (session) {
            var tx = session.beginTransaction();
            Course course = session.find(Course.class, courseId);
            session.remove(course);
            tx.commit();
        } catch (RuntimeException ex) {
            session.getTransaction().rollback();
            throw ex;
        }
    }

    @Override
    public List<Course> findAll() {
        try (var session = sessionFactory.openSession()) {
            return session.createQuery("from Course", Course.class).list();
        }
    }
}
