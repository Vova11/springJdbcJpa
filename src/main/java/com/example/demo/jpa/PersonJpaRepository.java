package com.example.demo.jpa;

import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Course;
import com.example.demo.pojo.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PersonJpaRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Person person) {
        entityManager.merge(person);
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id) {
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
    }

}
