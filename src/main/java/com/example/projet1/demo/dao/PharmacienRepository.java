package com.example.projet1.demo.dao;

import com.example.projet1.demo.entity.Person;
import com.example.projet1.demo.entity.Pharmacien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacienRepository extends JpaRepository<Pharmacien,Long> {
}
