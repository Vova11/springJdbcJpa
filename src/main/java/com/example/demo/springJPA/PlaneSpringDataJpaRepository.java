package com.example.demo.springJPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Plane;



public interface PlaneSpringDataJpaRepository extends JpaRepository<Plane, Long >{

    
    List<Plane> findBySize(String author);

}
