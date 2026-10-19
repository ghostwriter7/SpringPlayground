package com.rozplochowski.orm.repository;

import com.rozplochowski.orm.domain.Log;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class LogDao {

    @PersistenceContext
    private final EntityManager entityManager;

    @Transactional
    public void save(Log log) {
        entityManager.persist(log);
    }

    @Transactional
    public void delete(Long id) {
        var log = entityManager.find(Log.class, id);
        entityManager.remove(log);
    }

    @Transactional(readOnly = true)
    public Log findById(Long id) {
        return entityManager.find(Log.class, id);
    }

    @Transactional(readOnly = true)
    public List<Log> findAll() {
        return entityManager.createQuery("select l from Log l", Log.class).getResultList();
    }
}
