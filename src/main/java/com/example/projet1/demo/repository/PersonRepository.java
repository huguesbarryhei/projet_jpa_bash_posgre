package com.example.projet1.demo.repository;

import com.example.projet1.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Long> {

    List<Person> findPersonByMetier(String metier);

}
