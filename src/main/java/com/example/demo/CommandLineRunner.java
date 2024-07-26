package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.pojo.Plane;
import com.example.demo.springJPA.PlaneSpringDataJpaRepository;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner{
    // @Autowired
    // private CourseJdbcRepository repository;
    
    // @Autowired
    // private PersonJpaRepository repository;

    @Autowired
    public PlaneSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        //JDBC
        // repository.insert();
        
        //JDBC and JPA
        // repository.insert(new Person(1, "Learn JAVA", "sss"));
        // repository.insert(new Person(2, "Oracle", "sss"));
        // repository.insert(new Person(3, "Azure", "sss"));
        // repository.deleteById(1);
        // System.out.println(repository.findById(1));
        // System.out.println(repository.findById(2));

        repository.save(new Plane(1, "Jambo", "big"));
        repository.save(new Plane(2, "Cesna", "small"));
        repository.save(new Plane(3, "Airbus", "medium"));
        repository.deleteById(1l);
        System.out.println(repository.findById(1l));
        System.out.println(repository.findById(2l));

        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findBySize("small"));


    }

}
