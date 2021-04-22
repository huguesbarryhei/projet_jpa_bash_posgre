package com.example.projet1.demo.writer;

import com.example.projet1.demo.dao.PersonRepository;
import com.example.projet1.demo.dao.PharmacienRepository;
import com.example.projet1.demo.entity.Person;
import com.example.projet1.demo.entity.Pharmacien;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PharmacienItemWriter implements ItemWriter<Pharmacien> {

    @Autowired
    private PharmacienRepository pharmacienRepository;

    @Override
    public void write(List<? extends Pharmacien> items) throws Exception {
        System.out.println(items);
        pharmacienRepository.saveAll(items);
    }
}