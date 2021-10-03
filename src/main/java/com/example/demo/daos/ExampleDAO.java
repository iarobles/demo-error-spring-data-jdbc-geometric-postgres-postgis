package com.example.demo.daos;

import com.example.demo.entities.Example;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleDAO extends CrudRepository<Example, Long>{
    
}
